package com.ms_catalogos.service;

import com.ms_catalogos.dto.MedioPagoRequest;
import com.ms_catalogos.dto.MedioPagoResponse;
import com.ms_catalogos.entity.MedioPago;

import java.util.List;
import java.util.Optional;

public interface MedioPagoService {

    List<MedioPagoResponse> mostrar();
    MedioPagoResponse guardar(MedioPagoRequest request);
    MedioPagoResponse buscar(String descripcion);
}
