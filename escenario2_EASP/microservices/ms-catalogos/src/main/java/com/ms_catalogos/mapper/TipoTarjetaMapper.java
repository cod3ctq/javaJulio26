package com.ms_catalogos.mapper;

import com.ms_catalogos.dto.TipoTarjetaRequest;
import com.ms_catalogos.dto.TipoTarjetaResponse;
import com.ms_catalogos.entity.TipoTarjeta;

public class TipoTarjetaMapper {

    public static TipoTarjeta toEntity(TipoTarjetaRequest request){
        TipoTarjeta tT = new TipoTarjeta();

        tT.setTipoTId(request.getTipoId());
        tT.setDescripcion(request.getDescripcion());

        return tT;
    }

    public static TipoTarjetaResponse toResponse (TipoTarjeta tipoTarjeta){
        return new TipoTarjetaResponse(tipoTarjeta.getTipoTId(), tipoTarjeta.getDescripcion());
    }
}
