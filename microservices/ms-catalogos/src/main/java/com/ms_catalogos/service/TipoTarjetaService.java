package com.ms_catalogos.service;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.dto.TipoTarjetaResponse;
import com.ms_catalogos.entity.TipoTarjeta;

import java.util.List;
import java.util.Optional;

public interface TipoTarjetaService {

    List<TipoTarjetaResponse> mostrar();
    TipoCuentaResponse guardar(TipoCuentaRequest request);
    TipoCuentaResponse buscar(String descripcion);
}
