package com.ms_catalogos.mapper;


import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.entity.TipoCuenta;

public class TipoCuentaMapper {
    public static TipoCuenta toEntity(TipoCuentaRequest request){

        TipoCuenta tC = new TipoCuenta();

        tC.setTipoCuentaId(request.getTipoCuentaId());
        tC.setDescripcion(request.getDescripcion());
        tC.setSaldoMin(request.getSaldoMin());
        tC.setSaldoMax(request.getSaldoMax());

        return tC;
    }
    //Corregir
    public static TipoCuentaResponse toResponse (TipoCuenta tipoCuenta){
        return new TipoCuentaResponse(tipoCuenta.getTipoCuentaId(),
                tipoCuenta.getDescripcion(),
                tipoCuenta.getSaldoMin(),
                tipoCuenta.getSaldoMax()

        );
    }



}
