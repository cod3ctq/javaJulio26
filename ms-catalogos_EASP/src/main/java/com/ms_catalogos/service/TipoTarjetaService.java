package com.ms_catalogos.service;

import com.ms_catalogos.dto.TipoTarjetaRequest;
import com.ms_catalogos.dto.TipoTarjetaResponse;

import java.util.List;

public interface TipoTarjetaService {

    List<TipoTarjetaResponse> mostrar();

    TipoTarjetaResponse guardar (TipoTarjetaRequest request);

    TipoTarjetaResponse buscar (int id);


}
