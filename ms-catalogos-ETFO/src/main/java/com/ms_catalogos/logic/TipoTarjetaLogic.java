package com.ms_catalogos.logic;

import com.ms_catalogos.dto.TipoTarjetaRequest;
import com.ms_catalogos.dto.TipoTarjetaResponse;
import com.ms_catalogos.entity.TipoTarjeta;
import com.ms_catalogos.service.TipoTarjetaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTarjetaLogic implements TipoTarjetaService {
    @Override
    public List<TipoTarjeta> mostrar() {
        return List.of();
    }

    @Override
    public TipoTarjetaResponse guardar(TipoTarjetaRequest request) {
        return null;
    }

    @Override
    public TipoTarjetaResponse buscarPorDescripcion(String descripcion) {
        return null;
    }
}
