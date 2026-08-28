package com.ms_transacciones.service.impl;

import com.ms_transacciones.constants.Constantes;
import com.ms_transacciones.constants.Mensajes;
import com.ms_transacciones.dto.TarjetaRecord;
import com.ms_transacciones.dto.TicketResponse;
import com.ms_transacciones.dto.TransaccionRequest;
import com.ms_transacciones.entity.Cuenta;
import com.ms_transacciones.entity.Movimiento;
import com.ms_transacciones.entity.TipoCuenta;
import com.ms_transacciones.exception.AccountNotFoundException;
import com.ms_transacciones.exception.BussinessException;
import com.ms_transacciones.mapper.TransaccionMapper;
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
public class TransaccionImpl implements TransaccionesService {

    RestTemplate http = new RestTemplate();

    @Autowired
    CuentaRepository cuentaRepo;

    @Autowired
    TipoCuentaRepository tipoRepo;

    @Autowired
    MovimientoRepository movRepo;

    @Override
    public TicketResponse retirar(TransaccionRequest request) {

        //monto por transaccion <=10000
        //que el monto < saldo actual
        //la resta del saldo actual - monto >= minimo de la cuenta

        //Forma 1: Adquirir los datos consumiendo el endpoint del servicio especifico
        TarjetaRecord record = http.getForObject("http://localhost:8094/api/v1/tarjetas/by-num-tarjeta/"
                +request.getNumTarjeta(), TarjetaRecord.class);

        //Forma 2: Cada servicio es dueño de sus propios objetos y
        // los datos se adquieren directo desde la base
        //Optional<Cuenta> cuenta = cuentaRepo.findById(record.cuentaId());

        if (cuentaRepo.findById(record.cuentaId()).isEmpty()){
            throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        }else {
            Cuenta cuenta = cuentaRepo.findById(record.cuentaId()).get();
            Optional<TipoCuenta> tipoC = tipoRepo.findById(cuenta.getCuentaId());
            if (request.getMonto() % 100 != 0) {
                throw new BussinessException(Mensajes.INVALID_AMOUNT);
            } else if (request.getMonto() > Constantes.RETIRO_MAXIMO_TRANSACCION) {
                throw new BussinessException(Mensajes.WITHDRAWAL_EXCEEDS_MAXIMUM_LIMIT);
            } else if (cuenta.getSaldo() < request.getMonto()) {
                throw new BussinessException(Mensajes.INSUFFICIENT_ACCOUNT_BALANCE);
            } else if ((cuenta.getSaldo() - request.getMonto()) < tipoC.get().getSaldoMin()) {
                throw new BussinessException(Mensajes.WITHDRAWAL_BELOW_MINIMUM_BALANCE);
            } else {
                cuenta.setSaldo(cuenta.getSaldo() - request.getMonto());
                cuentaRepo.save(cuenta);
                Movimiento mov = new Movimiento();
                mov.setCuentaId(cuenta.getCuentaId());
                mov.setFecha(LocalDate.now());
                mov.setMonto(request.getMonto());
                mov.setTipo("RETIRO");

                movRepo.save(mov);

                return TransaccionMapper.toResponse(mov, cuenta);
            }
        }
    }

    @Override
    public TicketResponse depositar(TransaccionRequest request) {

        TarjetaRecord record = http.getForObject("http://localhost:8094/api/v1/tarjetas/by-num-tarjeta/"
                + request.getNumTarjeta(), TarjetaRecord.class);

        Cuenta cuenta = cuentaRepo.findById(record.cuentaId()).get();
        TipoCuenta tipoCuenta = tipoRepo.findById(cuenta.getCuentaId()).get();

        if (cuentaRepo.findById(record.cuentaId()).isEmpty()){
            throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        }else if (request.getMonto()>Constantes.DEPOSITO_MAXIMO_TRANSACCION){
            //maximo de deposito permitido
            throw new BussinessException(Mensajes.AMOUNT_EXCEEDING_MAXIMUM_DEPOSIT_LIMIT);
        } else if (request.getMonto() % 50 != 0 && request.getMonto() % 20 != 0) {
            //multiplos de 50 o 20
            throw new BussinessException(Mensajes.INVALID_QUANTITY_AMOUNT);
        } else if (request.getMonto() > tipoCuenta.getSaldoMax()) {
            //si el deposito es mayor que el saldo maximo de la cuenta
            throw new BussinessException(Mensajes.AMOUNT_EXCEEDING_ACCOUNT_LIMIT);
        } else {
            cuenta.setSaldo(cuenta.getSaldo() + request.getMonto());
            cuentaRepo.save(cuenta);

            Movimiento mov = new Movimiento();
            mov.setCuentaId(cuenta.getCuentaId());
            mov.setFecha(LocalDate.now());
            mov.setMonto(request.getMonto());
            mov.setTipo("DEPOSITO");

            movRepo.save(mov);

            return TransaccionMapper.toResponse(mov, cuenta);
        }
    }
}
