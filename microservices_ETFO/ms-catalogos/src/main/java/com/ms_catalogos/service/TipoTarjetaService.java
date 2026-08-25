package com.ms_catalogos.service;

import com.ms_catalogos.dto.TipoTarjetaRequest;
import com.ms_catalogos.dto.TipoTarjetaResponse;
import com.ms_catalogos.entity.TipoTarjeta;

import java.util.List;

public interface TipoTarjetaService {

    List<TipoTarjeta> mostrar();

    TipoTarjetaResponse guardar(TipoTarjetaRequest request);

    TipoTarjetaResponse buscarPorDescripcion(String descripcion);

}
