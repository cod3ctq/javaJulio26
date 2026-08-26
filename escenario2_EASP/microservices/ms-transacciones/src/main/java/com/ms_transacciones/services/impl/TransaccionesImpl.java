package com.ms_transacciones.services.impl;

import com.ms_transacciones.constants.Constantes;
import com.ms_transacciones.constants.Mensajes;
import com.ms_transacciones.dto.TarjetaRecord;
import com.ms_transacciones.dto.TicketResponse;
import com.ms_transacciones.dto.TransaccionRequest;
import com.ms_transacciones.entity.Cuenta;
import com.ms_transacciones.entity.Movimientos;
import com.ms_transacciones.entity.TipoCuenta;
import com.ms_transacciones.exceptions.AccountNotFoundException;
import com.ms_transacciones.exceptions.BusinessException;
import com.ms_transacciones.mapper.TransaccionMapper;
import com.ms_transacciones.repository.CuentaRepository;
import com.ms_transacciones.repository.MovimientosRepository;
import com.ms_transacciones.repository.TipoCuentaRepository;
import com.ms_transacciones.services.TransaccionesService;
import jakarta.ws.rs.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransaccionesImpl implements TransaccionesService{

    RestTemplate http = new RestTemplate();

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    TipoCuentaRepository tipoCuentaRepository;

    @Autowired
    MovimientosRepository movimientosRepository;


    @Override
    public TicketResponse retirar(TransaccionRequest request) {
        //Forma 1: Adquirir los datos consumiendo el endpoint del servicio especificado
        TarjetaRecord record = http.getForObject(
                "http://localhost:8094/api/v1/tarjetas/by-num-tarjeta/"+request.getNumTarjeta(),
                TarjetaRecord.class);
        //Forma 2: Cada servicio es dueño de sus propios objetos y los datos se adquieren directo desde la base

        if(cuentaRepository.findById(record.cuentaId()).isEmpty()){
            throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        }else {
            Cuenta cuenta = cuentaRepository.findById(record.cuentaId()).get();
            TipoCuenta tipoCuenta = tipoCuentaRepository.findById(cuenta.getTipoCuentaId()).get();

            if ((request.getMonto() % 100) != 0) {
                throw new BusinessException(Mensajes.INVALID_AMOUNT);
            } else if (request.getMonto() > Constantes.RETIRO_MAXIMO_TRANSACCION) {
                throw new BusinessException(Mensajes.WITHDRAWAL_EXCEEDS_MAXIMUM_TRANSACTION_LIMIT);
            } else if (request.getMonto() > cuenta.getSaldo()) {
                throw new BusinessException(Mensajes.INSUFFICIENT_ACCOUNT_BALANCE);
            } else if (cuenta.getSaldo() - request.getMonto() < tipoCuenta.getSaldoMin()) {
                throw new BusinessException(Mensajes.MINIMUM_BALANCE_REACHED);
            } else {
                cuenta.setSaldo(cuenta.getSaldo() - request.getMonto());
                cuentaRepository.save(cuenta);

                Movimientos mov = new Movimientos();
                mov.setCuentaId(cuenta.getCuentaId());
                mov.setFecha(LocalDate.now());
                mov.setMonto(request.getMonto());
                mov.setTipo("RETIRO");
                movimientosRepository.save(mov);

                return TransaccionMapper.toResponse(mov, cuenta);
            }
        }
    }

    @Override
    public TicketResponse depositar(TransaccionRequest request) {
        TarjetaRecord record = http.getForObject(
                "http://localhost:8094/api/v1/tarjetas/by-num-tarjeta/"+request.getNumTarjeta(),
                TarjetaRecord.class);
        if (cuentaRepository.findById(record.cuentaId()).isEmpty()){
            throw new BusinessException(Mensajes.ACCOUNT_NOT_FOUND);
        }else {
            Cuenta cuenta = cuentaRepository.findById(record.cuentaId()).get();
            TipoCuenta tipoCuenta = tipoCuentaRepository.findById(cuenta.getTipoCuentaId()).get();

            if (request.getMonto()>Constantes.DEPOSITO_MAXIMO_TRANSACCION) {
                throw new BusinessException(Mensajes.DEPOSIT_EXCEEDS_TRANSACTION_LIMIT);
            } else if (cuenta.getSaldo() + request.getMonto() > tipoCuenta.getSaldoMax()) {
                throw new BusinessException(Mensajes.MAXIMUM_BALANCE_REACHED);
            }else {
                cuenta.setSaldo(cuenta.getSaldo() + request.getMonto());
                cuentaRepository.save(cuenta);

                Movimientos mov = new Movimientos();
                mov.setCuentaId(cuenta.getCuentaId());
                mov.setFecha(LocalDate.now());
                mov.setMonto(request.getMonto());
                mov.setTipo("DEPOSITO");
                movimientosRepository.save(mov);

                return TransaccionMapper.toResponse(mov, cuenta);
            }

        }
    }
}
