package com.ms_catalogos.logic;

import com.ms_catalogos.dto.TipoPrestamoRequest;
import com.ms_catalogos.dto.TipoPrestamoResponse;
import com.ms_catalogos.service.TipoPrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoPrestamoLogic implements TipoPrestamoService {

    @Override
    public List<TipoPrestamoResponse> mostrar() {
        return List.of();
    }

    @Override
    public TipoPrestamoResponse guardar(TipoPrestamoRequest request) {
        return null;
    }

    @Override
    public TipoPrestamoResponse buscar(String descripcion) {
        return null;
    }

    @Override
    public TipoPrestamoResponse actualizarDatos(TipoPrestamoRequest request) {
        return null;
    }
}

