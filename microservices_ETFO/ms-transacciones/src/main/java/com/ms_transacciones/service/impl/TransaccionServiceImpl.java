package com.ms_transacciones.service.impl;

import com.ms_transacciones.constants.Constants;
import com.ms_transacciones.constants.Mensajes;
import com.ms_transacciones.dto.*;
import com.ms_transacciones.entity.Cuenta;
import com.ms_transacciones.entity.Movimiento;
import com.ms_transacciones.entity.TipoCuenta;
import com.ms_transacciones.exception.AccountNotFoundException;
import com.ms_transacciones.exception.BusinessException;
import com.ms_transacciones.mapper.TransaccionesMapper;
import com.ms_transacciones.repository.CuentaRepository;
import com.ms_transacciones.repository.MovimientoRepository;
import com.ms_transacciones.repository.TipoCuentaRepository;
import com.ms_transacciones.service.TransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionesService {

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    TipoCuentaRepository tipoCuentaRepository;

    @Autowired
    MovimientoRepository movimientoRepository;

    RestTemplate http = new RestTemplate();

    @Override
    public TicketResponse retirar(TransaccionRequest transaccionRequest) {
        //Forma 1: Adquirir los datos consultando el endpoint del servicio especifico
        TarjetaRecord tarjetaRecord = http.getForObject("http://localhost:8094/api/v1/tarjetas/num-tarjeta/" + transaccionRequest.getNumTarjeta(),TarjetaRecord.class);
        /*CuentaRecord cuentaRecord = http.getForObject("http://localhost:8091/api/v1/cuentas/" + tarjetaRecord.cuentaId(),CuentaRecord.class);
        TipoCuentaRecord tipoCuentaRecord = http.getForObject("http://localhost:8092/api/v1/catalogos/tipo-cuenta/by-id/" + cuentaRecord.tipoCuentaId(),TipoCuentaRecord.class);*/

        //Forma 2 : cada servicio es dueño de sus propios objetos y los datos dquieran
        Optional<Cuenta> cuentaOptional = cuentaRepository.findCuentaById(tarjetaRecord.cuentaId());
        //Que el monto < saldo actual
        //La resta del saldo actual - monto >= minimo de la cuenta
        //Monto por transaccion <=10,000
        if(cuentaOptional.isEmpty()) {
            throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        }else {
            Cuenta cuenta = cuentaOptional.get();
            Optional<TipoCuenta> tipoCuentaOptional= tipoCuentaRepository.findTipoCuentaById(cuentaOptional.get().getTipoCuentaId());
            if(transaccionRequest.getMonto()%100!=0){
                throw new BusinessException(Mensajes.INVALID_AMOUNT);
            }else if(transaccionRequest.getMonto() > Constants.RETIRO_MAXIMO_TRANSACCION){
                throw new BusinessException(Mensajes.WITHDRAWAL_EXCEEDS_MAXIMUM_LIMIT);
            }else if(transaccionRequest.getMonto() > cuenta.getSaldo()) {
                throw new BusinessException(Mensajes.INSUFFICIENT_ACCOUNT_BALANCE);
            }else if(cuenta.getSaldo() - transaccionRequest.getMonto() < tipoCuentaOptional.get().getSaldoMin()) {
                throw new BusinessException(Mensajes.WITHDRAWAL_BELOW_MINIMUM_BALANCE);
            } else {
                cuenta.setSaldo(cuenta.getSaldo() - transaccionRequest.getMonto());
                cuentaRepository.save(cuenta);

                Movimiento movimiento = new Movimiento();
                movimiento.setCuentaId(cuenta.getCuentaId());
                movimiento.setFecha(LocalDate.now());
                movimiento.setTipo("RETIRO");
                movimiento.setMonto(transaccionRequest.getMonto());
                movimientoRepository.save(movimiento);

                return TransaccionesMapper.toResponse(movimiento, cuenta);
            }
        }
    }

    @Override
    public TicketResponse depositar(TransaccionRequest transaccionRequest) {
        TarjetaRecord tarjetaRecord = http.getForObject("http://localhost:8094/api/v1/tarjetas/num-tarjeta/" + transaccionRequest.getNumTarjeta(),TarjetaRecord.class);

        Optional<Cuenta> cuentaOptional = cuentaRepository.findCuentaById(tarjetaRecord.cuentaId());

        if(cuentaOptional.isEmpty()) {
            throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        } else if(transaccionRequest.getMonto()%100!=0){
            throw new BusinessException(Mensajes.INVALID_AMOUNT);
        } else {
            Cuenta cuenta = cuentaOptional.get();
            TipoCuenta tipoCuenta = tipoCuentaRepository.findTipoCuentaById(cuentaOptional.get().getTipoCuentaId()).get();
            if (transaccionRequest.getMonto() > Constants.DEPOSITO_MAXIMO_TRANSACCION){
                throw new BusinessException(Mensajes.WITHDRAWAL_EXCEEDS_MAXIMUM_LIMIT);
            }else if((transaccionRequest.getMonto() + cuenta.getSaldo()) > tipoCuenta.getSaldoMax()) {
                throw new BusinessException(Mensajes.DEPOSIT_ABOVE_MAXIMUM_LIMIT);
            }else{
                cuentaOptional.get().setSaldo(cuentaOptional.get().getSaldo() - transaccionRequest.getMonto());
                cuentaRepository.save(cuentaOptional.get());

                Movimiento movimiento = new Movimiento();
                movimiento.setCuentaId(cuentaOptional.get().getCuentaId());
                movimiento.setFecha(LocalDate.now());
                movimiento.setTipo("DEPOSITO");
                movimiento.setMonto(transaccionRequest.getMonto());
                movimientoRepository.save(movimiento);

                return TransaccionesMapper.toResponse(movimiento, cuentaOptional.get());
            }
        }
    }
}

