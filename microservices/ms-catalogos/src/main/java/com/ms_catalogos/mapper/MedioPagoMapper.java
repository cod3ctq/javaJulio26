package com.ms_catalogos.mapper;

import com.ms_catalogos.dto.MedioPagoRequest;
import com.ms_catalogos.dto.MedioPagoResponse;
import com.ms_catalogos.entity.MedioPago;

public class MedioPagoMapper {

    public static MedioPago toEntity(MedioPagoRequest request){

        MedioPago mP = new MedioPago();

        mP.setMedioId(request.getMedioId());
        mP.setDescripcion(request.getDescripcionMedioPago());

        return mP;
    }

    public static MedioPagoResponse toResponse (MedioPago medioPago){
        return new MedioPagoResponse(
                medioPago.getMedioId(),
                medioPago.getDescripcion());
    }

}
