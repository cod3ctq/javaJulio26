package com.ms_catalogos.mapper;

import com.ms_catalogos.dto.TipoPrestamoRequest;
import com.ms_catalogos.dto.TipoPrestamoResponse;
import com.ms_catalogos.entity.TipoPrestamo;

public class TipoPrestamoMapper {

    public static TipoPrestamo toEntity(TipoPrestamoRequest request){
        TipoPrestamo tP = new TipoPrestamo();

        tP.setTipoPrestamoId(request.getTipoPrestamoId());
        tP.setDescripcion(request.getDescripcion());
        tP.setInteres(request.getInteres());
        tP.setPlazo(request.getPlazo());

        return tP;
    }

    public static TipoPrestamoResponse toResponse(TipoPrestamo tipoPrestamo){
        return new TipoPrestamoResponse(
                tipoPrestamo.getTipoPrestamoId(),
                tipoPrestamo.getDescripcion(),
                tipoPrestamo.getInteres(),
                tipoPrestamo.getPlazo()
        );
    }
}
