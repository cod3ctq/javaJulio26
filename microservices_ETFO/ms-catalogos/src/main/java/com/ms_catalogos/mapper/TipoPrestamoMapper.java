package com.ms_catalogos.mapper;

import com.ms_catalogos.dto.TipoPrestamoRequest;
import com.ms_catalogos.dto.TipoPrestamoResponse;
import com.ms_catalogos.entity.TipoPrestamo;

public class TipoPrestamoMapper {

    public static TipoPrestamo toEntity(TipoPrestamoRequest request){

        TipoPrestamo tipoPrestamo = new TipoPrestamo();

        tipoPrestamo.setTipoPrestamoId(request.getTipoPrestamoId());
        tipoPrestamo.setDescripcion(request.getDescripcion());
        tipoPrestamo.setInteres(request.getInteres());
        tipoPrestamo.setPlazo(request.getPlazo());

        return tipoPrestamo;
    }

    public static TipoPrestamoResponse toResponse (TipoPrestamo tipoPrestamo){
        return new TipoPrestamoResponse(
                tipoPrestamo.getTipoPrestamoId(),
                tipoPrestamo.getDescripcion(),
                tipoPrestamo.getInteres(),
                tipoPrestamo.getPlazo()
        );
    }

}
