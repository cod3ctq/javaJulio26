package com.ms_catalogos.service;

import com.ms_catalogos.dto.MedioPagoRequest;
import com.ms_catalogos.dto.MedioPagoResponse;
import com.ms_catalogos.dto.TipoTarjetaRequest;
import com.ms_catalogos.dto.TipoTarjetaResponse;
import com.ms_catalogos.entity.MedioPago;
import com.ms_catalogos.entity.TipoTarjeta;

import java.util.List;
import java.util.Optional;

public interface TipoTarjetaService {

    List<TipoTarjetaResponse> mostrar();
    TipoTarjetaResponse guardar(TipoTarjetaRequest request);
    TipoTarjetaResponse buscar(String descripcion);
}
