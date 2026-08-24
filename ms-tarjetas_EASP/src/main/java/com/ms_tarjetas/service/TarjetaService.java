package com.ms_tarjetas.service;

import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.dto.TarjetaResponse;

import java.util.List;

public interface TarjetaService {

    TarjetaResponse nuevaTarjeta (TarjetaRequest request);

    TarjetaResponse buscarTarjeta (int tarjetaId);

    TarjetaResponse buscarTarjeta (String numTarjeta);

    TarjetaResponse actualizarTarjeta (TarjetaRequest request);

    String eliminar (int tarjetaId);

    String desactivarTarjeta (String numTarjeta);

    List mostrar ();
}
