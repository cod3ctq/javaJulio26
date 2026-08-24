package com.ms_catalogos.mapper;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.entity.TipoCuenta;

public class TipoCuentaMapper {
    public static TipoCuenta toEntity(TipoCuentaRequest request){

        TipoCuenta tipoCuenta = new TipoCuenta();

        tipoCuenta.setTipoCuentaId(request.getTipoCuentaId());
        tipoCuenta.setDescripcion(request.getDescripcion());
        tipoCuenta.setSaldoMin(request.getSaldoMin());
        tipoCuenta.setSaldoMax(request.getSaldoMax());

        return tipoCuenta;
    }

    public static TipoCuentaResponse toResponse (TipoCuenta tipoCuenta){
        return new TipoCuentaResponse(
                tipoCuenta.getTipoCuentaId(),
                tipoCuenta.getDescripcion(),
                tipoCuenta.getSaldoMin(),
                tipoCuenta.getSaldoMax());
    }
}
