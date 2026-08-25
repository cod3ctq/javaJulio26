package com.ms_tarjetas.service;

import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.dto.TarjetaResponse;

import java.util.List;

public interface TarjetaService {

    TarjetaResponse crearTarjeta(TarjetaRequest request);

    List verTarjetas();

    TarjetaResponse actualizarTarjeta(TarjetaRequest request);

    String eliminarTarjeta(int tarjetaId);

    TarjetaResponse obtenerTarjetaPorId(int tarjetaId);

    TarjetaResponse obtenerTarjetaPorNumTarjeta(String numTarjeta);
}
