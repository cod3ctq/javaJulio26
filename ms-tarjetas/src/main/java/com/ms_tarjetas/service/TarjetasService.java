package com.ms_tarjetas.service;


import com.ms_tarjetas.dto.TarjetaRequest;

import java.util.List;

public interface TarjetasService {

    TarjetaResponse crearTarjeta (TarjetaRequest request);
    TarjetaResponse buscarTarjeta (int tarjetaId);
    TarjetaResponse buscarTarjeta (String numCuenta);
    TarjetaResponse buscarTarjeta ();

    TarjetaResponse actualizarTarjeta (TarjetaRequest request);

    String eliminar (int tarjetaId);
    String desactivartarjeta (String numTarjeta);
    List mostrar ();

}
