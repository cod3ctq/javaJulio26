package com.ms_cuentas.mapper;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.entity.Cuenta;
import com.ms_cuentas.util.CuentaHelper;

import java.time.LocalDate;

//Clases mappers : Se encargan de recibir y convertir un objeto de un tipo de dato a otro
public class CuentaMapper {

    public static Cuenta toEntity(CuentaRequest cuentaRequest) {
        Cuenta cuenta = new Cuenta();

        cuenta.setClienteId(cuentaRequest.getClienteId());
        cuenta.setTipoCuentaId(cuentaRequest.getTipoCuentaId());
        cuenta.setSaldo(cuentaRequest.getSaldo());
        cuenta.setFecha(LocalDate.now());
        cuenta.setStatus('1');
        cuenta.setNumCuenta(CuentaHelper.generarNumCuenta());
        cuenta.setClabe(CuentaHelper.generarClabe());

        return cuenta;
    }

    public static CuentaResponse toResponse(Cuenta cuenta) {
        return new CuentaResponse
                (
                        cuenta.getCuentaId(),
                        cuenta.getTipoCuentaId(),
                        cuenta.getNumCuenta(),
                        cuenta.getClabe(),
                        cuenta.getSaldo(),
                        cuenta.getFecha()
                );
    }

    public static Cuenta toUpdateEntity(Cuenta old, CuentaRequest cuentaRequest) {

        old.setClienteId(cuentaRequest.getClienteId());
        old.setTipoCuentaId(cuentaRequest.getTipoCuentaId());
        old.setSaldo(cuentaRequest.getSaldo());
        old.setFecha(LocalDate.now());
        old.setStatus('1');
        old.setNumCuenta(CuentaHelper.generarNumCuenta());
        old.setClabe(CuentaHelper.generarClabe());

        return old;
    }
}
