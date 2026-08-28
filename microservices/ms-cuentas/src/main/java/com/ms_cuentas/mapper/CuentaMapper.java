package com.ms_cuentas.mapper;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.entity.Cuenta;
import util.CuentaHelper;

import java.time.LocalDate;

//clases mapper se encargan de recibir y convertir un objeto de un
// tipo de dato a otro
public class CuentaMapper {

    public static Cuenta toEntity(CuentaRequest request){

        Cuenta cuenta = new Cuenta();

        cuenta.setClienteId(request.getClienteId());
        cuenta.setTipoCuentaId(request.getTipoCuentaId());
        cuenta.setSaldo(request.getSaldo());
        cuenta.setFecha(LocalDate.now());
        cuenta.setStatus('1');
        cuenta.setNumCuenta(CuentaHelper.generarNumCuenta());
        cuenta.setClabe(CuentaHelper.generarClabe());

        return cuenta;
    }

    public static CuentaResponse toResponse (Cuenta cuenta){
        return new CuentaResponse(
                cuenta.getCuentaId(),
                cuenta.getClienteId(),
                cuenta.getTipoCuentaId(),
                cuenta.getNumCuenta(),
                cuenta.getClabe(),
                cuenta.getSaldo(),
                cuenta.getFecha());
    }

    public static Cuenta toUpdateEntity (Cuenta old, CuentaRequest request){

        old.setClienteId(request.getClienteId());
        old.setTipoCuentaId(request.getTipoCuentaId());
        old.setNumCuenta(CuentaHelper.generarNumCuenta());
        old.setClabe(CuentaHelper.generarClabe());
        old.setFecha(LocalDate.now());
        old.setStatus('1');
        old.setSaldo(request.getSaldo());

        return old;
    }
}
