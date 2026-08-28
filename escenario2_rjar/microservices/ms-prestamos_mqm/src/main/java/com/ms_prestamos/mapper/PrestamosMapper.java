package com.ms_prestamos.mapper;

import com.ms_prestamos.dto.PrestamosRequest;
import com.ms_prestamos.dto.PrestamosResponse;
import com.ms_prestamos.entity.Prestamos;
import com.ms_prestamos.util.PrestamosHelper;

import java.time.LocalDate;

public class PrestamosMapper {

    public static Prestamos toEntity (PrestamosRequest request){

        Prestamos prestamo = new Prestamos();

        prestamo.setPrestamoId(request.getPrestamoId());
        prestamo.setTipoPrestamoId(request.getTipoPrestamoId());
        prestamo.setClienteId(request.getClienteId());
        prestamo.setFecha(LocalDate.now());
        prestamo.setMonto(request.getMonto());
        prestamo.setFechaFin(PrestamosHelper.fechaFin());
        prestamo.setRestante(request.getMonto());

        return prestamo;

    }

    public static PrestamosResponse toResponse(Prestamos prestamo){
        return new PrestamosResponse(
                prestamo.getPrestamoId(),
                prestamo.getClienteId(),
                prestamo.getFecha(),
                prestamo.getTipoPrestamoId(),
                prestamo.getMonto(),
                prestamo.getFechaFin());
    }

    public static Prestamos toUpdateEntity(Prestamos prestamo, PrestamosRequest request){

        prestamo.setPrestamoId(request.getPrestamoId());
        prestamo.setClienteId(request.getClienteId());
        prestamo.setFecha(LocalDate.now());
        prestamo.setTipoPrestamoId(request.getTipoPrestamoId());
        prestamo.setMonto(request.getMonto());
        prestamo.setFechaFin(PrestamosHelper.fechaFin());
        prestamo.setRestante(prestamo.getRestante()- prestamo.getMonto());

        return prestamo;
    }
}
