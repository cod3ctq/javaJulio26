package com.ms_catalogos.logic;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.dto.TipoTarjetaRequest;
import com.ms_catalogos.dto.TipoTarjetaResponse;
import com.ms_catalogos.service.TipoTarjetaService;

import java.util.List;

public class TipoTarjetaLogic implements TipoTarjetaService {

    @Override
    public List<TipoTarjetaResponse> mostrar() {
        return List.of();
    }

    @Override
    public TipoTarjetaResponse guardar(TipoTarjetaRequest request) {
        return null;
    }

    @Override
    public TipoTarjetaResponse buscar(String descripcion) {
        return null;
    }
}
