package com.ms_catalogos.logic;


import com.ms_catalogos.dto.TipoPrestamoRequest;
import com.ms_catalogos.dto.TipoPrestamoResponse;
import com.ms_catalogos.entity.TipoCuenta;
import com.ms_catalogos.entity.TipoPrestamo;
import com.ms_catalogos.mapper.TipoCuentaMapper;
import com.ms_catalogos.mapper.TipoPrestamoMapper;
import com.ms_catalogos.repository.TipoPrestamoRepository;
import com.ms_catalogos.service.TipoPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoPrestamoLogic implements TipoPrestamoService {

    @Autowired
    TipoPrestamoRepository repo;

    @Override
    public List<TipoPrestamoResponse> mostrar() {
        List<TipoPrestamoResponse> response = new ArrayList<>();
        for(TipoPrestamo tp:repo.findAll()){
            response.add(TipoPrestamoMapper.toResponse(tp));
        }
        return response;
    }

    @Override
    public TipoPrestamoResponse guardar(TipoPrestamoRequest request) {
        TipoPrestamo tp = new TipoPrestamo();
        tp = TipoPrestamoMapper.toEntity(request);
        repo.save(tp);
        return TipoPrestamoMapper.toResponse(tp);
    }

    @Override
    public TipoPrestamoResponse buscar(String descripcion) {
        TipoPrestamo tp = repo.findByDescripcion(descripcion).get();
        return TipoPrestamoMapper.toResponse(tp);
    }

    @Override
    public TipoPrestamoResponse actualizarDatos(TipoPrestamoRequest request) {
        return null;
    }
}
