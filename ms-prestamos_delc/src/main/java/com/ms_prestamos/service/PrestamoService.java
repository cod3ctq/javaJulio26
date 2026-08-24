package com.ms_prestamos.service;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrestamoService {


    List<PrestamoResponse> mostrar ();

    PrestamoResponse buscarPorId(int prestamoId);
    PrestamoResponse crearPrestamo(PrestamoRequest request);
    List<PrestamoResponse> buscarPorCliente (int clienteId);
    PrestamoResponse abonarAPrestamo(int prestamoId, double montoAbono);


}
