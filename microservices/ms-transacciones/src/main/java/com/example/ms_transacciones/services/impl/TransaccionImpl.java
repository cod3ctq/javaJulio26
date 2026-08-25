package com.example.ms_transacciones.services.impl;

import com.example.ms_transacciones.constanst.Constants;
import com.example.ms_transacciones.constanst.Mensajes;
import com.example.ms_transacciones.dto.TarjetaRecord;
import com.example.ms_transacciones.dto.TicketResponse;
import com.example.ms_transacciones.dto.TransaccionRequest;
import com.example.ms_transacciones.entity.Cuenta;
import com.example.ms_transacciones.entity.Movimiento;
import com.example.ms_transacciones.entity.TipoCuenta;
import com.example.ms_transacciones.excepcion.AccountNotFoundException;
import com.example.ms_transacciones.excepcion.BusinessException;
import com.example.ms_transacciones.mapper.TransaccionMapper;
import com.example.ms_transacciones.repository.CuentaRepository;
import com.example.ms_transacciones.repository.MovimientoRepository;
import com.example.ms_transacciones.repository.TipoCuentaRepository;
import com.example.ms_transacciones.services.TransaccionesService;
import jakarta.ws.rs.BadRequestException;
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
    TipoCuentaRepository tipoCuentaRepo;

    @Autowired
    MovimientoRepository movRepo;

    @Override
    public TicketResponse retirar(TransaccionRequest request) {

        //Forma 1 = Adquirir los datos consumiendo el endpoint del servicio específico
        TarjetaRecord record = http.getForObject("http://localhost:8094/api/v1/tarjetas/by-num-tarjeta/" + request.getNumTarjeta(),
                TarjetaRecord.class);

        if (cuentaRepo.findById(record.cuentaId()).isEmpty()) {
            throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        } else {
            //Forma 2: Cada servicio es dueño de sus propios objetos y los datos se adquieren directo desde la base de datos
            Cuenta cuenta = cuentaRepo.findById(record.cuentaId()).get();
            Optional <TipoCuenta> tipoC = tipoCuentaRepo.findById(cuenta.getTipoCuentaId());

            // Monto por transacción debe ser <= $10,000
            // Que el monto < saldo actual
            //La resta del saldo actual - monto tiene que ser mayor o igual al mínimo de la cuenta

            if (request.getMonto() > Constants.RETIRO_MAXIMO_TRANSACCION) {
                throw new BusinessException(Mensajes.WITHDRAWAL_EXCEEDS_MAXIMUM_LIMIT);
            } else if (cuenta.getSaldo() < request.getMonto()) {
                throw new BusinessException(Mensajes.INSUFFICIENT_ACCOUNT_BALANCE);
            } else if ((cuenta.getSaldo() - request.getMonto()) < tipoC.get().getSaldoMin()) {
                throw new BusinessException(Mensajes.WITHDRAWAL_BELOW_MINIMUM_BALANCE);
            } else {
                cuenta.setSaldo(cuenta.getSaldo() - request.getMonto());
                cuentaRepo.save(cuenta);

                //Se puede generar esto en un Mapper
                Movimiento mov = new Movimiento();
                mov.setCuentaId(cuenta.getCuentaId());
                mov.setFecha(LocalDate.now());
                mov.setMonto(request.getMonto());
                mov.setTipo("RETIRO");
                //Todo lo anterior se puede ir a un Mapper

                movRepo.save(mov);

                TicketResponse response = TransaccionMapper.toResponse(mov, cuenta);
                return response;
            }
        }
    }

    @Override
    public TicketResponse depositar(TransaccionRequest request) {
        //Aquí buscamos los datos o el registro de la tabla Tarjetas con el numTarjeta que se coloque en el Request
        // (PostMan, por ejemplo)
        TarjetaRecord record = http.getForObject("http://localhost:8094/api/v1/tarjetas/by-num-tarjeta/"
                        +request.getNumTarjeta(),
                TarjetaRecord.class); //Después se va a guardar lo obtenido a TarjetaRecord.

        //Aquí vamos a guardar en la clase Cuenta
        if(cuentaRepo.findById(record.cuentaId()).isEmpty()){
           throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        } else {
            Cuenta cuenta = cuentaRepo.findById(record.cuentaId()).get();
            Optional <TipoCuenta> tipoC = tipoCuentaRepo.findById(cuenta.getTipoCuentaId());

            // Monto por transacción debe ser <= $12,000
            //
            //La suma del saldo actual + monto tiene que ser menor o igual al máximo de la cuenta
            if (request.getMonto()%100 != 0){
                throw new BusinessException(Mensajes.INVALID_AMOUNT);
            } else if(request.getMonto()> Constants.DEPOSITO_MAXIMO_TRANSACCION){
                throw new BusinessException(Mensajes.WITHDRAWAL_EXCEEDS_MAXIMUM_LIMIT);
            } else if ((cuenta.getSaldo() + request.getMonto()) > tipoC.get().getSaldoMax()) {
                throw new BusinessException(Mensajes.WITHDRAWAL_EXCEED_MAXIMUM_BALANCE);
            }else{
                cuenta.setSaldo(cuenta.getSaldo()+request.getMonto());
                cuentaRepo.save(cuenta);

                //Se puede generar esto en un Mapper
                Movimiento mov = new Movimiento();
                mov.setCuentaId(cuenta.getCuentaId());
                mov.setFecha(LocalDate.now());
                mov.setMonto(request.getMonto());
                mov.setTipo("DEPOSITO");
                //Todo lo anterior se puede ir a un Mapper

                movRepo.save(mov);

                TicketResponse response = TransaccionMapper.toResponse(mov,cuenta);
                return response;
            }
        }

    }
}
