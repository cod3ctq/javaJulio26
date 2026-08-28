package com.ms_transacciones.service.impl;

import com.ms_transacciones.constants.Constants;
import com.ms_transacciones.constants.Mensajes;
import com.ms_transacciones.dto.TarjetaRecord;
import com.ms_transacciones.dto.TicketResponse;
import com.ms_transacciones.dto.TransaccionRequest;
import com.ms_transacciones.entity.Cuenta;
import com.ms_transacciones.entity.Movimiento;
import com.ms_transacciones.entity.TipoCuenta;
import com.ms_transacciones.exception.AccountNotFoundException;
import com.ms_transacciones.exception.BusinessException;
import com.ms_transacciones.mapper.TransaccionMapper;
import com.ms_transacciones.repository.CuentaRepository;
import com.ms_transacciones.repository.MovimientoRepository;
import com.ms_transacciones.repository.TipoCuentaRepository;
import com.ms_transacciones.service.TransaccionesService;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
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
    TipoCuentaRepository tipoCuentaRepository;
    @Autowired
    MovimientoRepository movRepo;

    @Override
    public TicketResponse retirar(TransaccionRequest request) {

        //Forma1: Adquirir los datos consumiendo el endpoint sel servicio especifico
        TarjetaRecord record = http.getForObject("http://localhost:8094/api/v1/tarjetas/by-num-tarjeta/"
                + request.getNumTarjeta(), TarjetaRecord.class);
        //Forma2: Cada servicio es dueño de sus propios objetos y los datos se adquieren
        //directo desde la base

        if(cuentaRepo.findById(record.cuentaId()).isEmpty()) {
            throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        } else{
                Cuenta cuenta = cuentaRepo.findById(record.cuentaId()).get();
                Optional<TipoCuenta> tipoC = tipoCuentaRepository.findById(cuenta.getTipoCuentaId());

                //monto por transaccion <=10000 que el monto<saldo actual, la resta del sado actual-monto>=minimo de la cuenta
                if ((request.getMonto() % 100 != 0)) {
                    throw new BusinessException(Mensajes.INVALID_AMOUNT);
                } else if (request.getMonto() > Constants.RETIRO_MAXIMO_TRANSACCION) {
                    throw new BusinessException(Mensajes.WITHDRAWAL_EXCEEDS_MAXIMUM_LIMIT);
                } else if (cuenta.getSaldo() < request.getMonto()) {
                    throw new BusinessException(Mensajes.INSUFFICIENT_ACCOUNT_BALANCE);
                } else if ((cuenta.getSaldo() - request.getMonto()) < tipoC.get().getSaldoMin()) {
                    throw new BusinessException(Mensajes.WITHDRAWAL_BELOW_MINIMUM_BALANCE);
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
        // 1. Obtener los datos de la tarjeta desde el microservicio
        TarjetaRecord record = http.getForObject("http://localhost:8094/api/v1/tarjetas/by-num-tarjeta/"
                + request.getNumTarjeta(), TarjetaRecord.class);

        // 2. Validar si la cuenta existe (Buscamos una sola vez para optimizar)
        Optional<Cuenta> cuentaOpt = cuentaRepo.findById(record.cuentaId());
        if (cuentaOpt.isEmpty()) {
            throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        }

        Cuenta cuenta = cuentaOpt.get();

        // 3. Validaciones de negocio para el depósito
        if (request.getMonto() % 100 != 0) {
            throw new BusinessException(Mensajes.INVALID_AMOUNT);
        }
        // Nota: Si tienes un límite de depósito máximo, añade la validación aquí

        // 4. Actualizar el saldo (Sumar el monto)
        cuenta.setSaldo(cuenta.getSaldo() + request.getMonto());
        cuentaRepo.save(cuenta);

        // 5. Registrar el movimiento de depósito
        Movimiento mov = new Movimiento();
        mov.setCuentaId(cuenta.getCuentaId());
        mov.setFecha(LocalDate.now());
        mov.setMonto(request.getMonto());
        mov.setTipo("DEPOSITO");
        movRepo.save(mov);

        // 6. Retornar la respuesta mapeada
        return TransaccionMapper.toResponse(mov, cuenta);
    }


    }

