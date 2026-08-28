package com.ms_prestamos.service;

import com.ms_prestamos.dto.PrestamosRequest;
import com.ms_prestamos.dto.PrestamosResponse;

import java.util.List;

public interface PrestamosService {

    PrestamosResponse crearPrestamo(PrestamosRequest request);
    PrestamosResponse buscarPrestamo(int prestamoId);
    PrestamosResponse actualizarPrestamo(PrestamosRequest request);
    String eliminar (int prestamoId);
    List mostrar();

}
