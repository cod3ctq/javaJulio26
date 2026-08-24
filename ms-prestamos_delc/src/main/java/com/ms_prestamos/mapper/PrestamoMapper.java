package com.ms_prestamos.mapper;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.entity.Prestamo;

public class PrestamoMapper {

    public static Prestamo toEntity(PrestamoRequest request){
        if (request == null){
        return null;
        }
        Prestamo p = new Prestamo();

        p.setPrestamoId(request.getPrestamoId());
        p.setTipoId(request.getTipoId());
        p.setClienteId(request.getClienteId());
        p.setMonto(request.getMonto());

        p.setRestante(request.getMonto());

        return p;

    }

    public static PrestamoResponse toResponse(Prestamo prestamo){
        if (prestamo == null){
            return null;
        }
        return new PrestamoResponse(
                prestamo.getClienteId(),
                prestamo.getTipoId(),
                prestamo.getFecha(),
                prestamo.getMonto(),
                prestamo.getPrestamoId());
    }

}
