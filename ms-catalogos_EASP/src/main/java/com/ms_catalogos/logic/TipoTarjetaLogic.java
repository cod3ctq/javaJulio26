package com.ms_catalogos.logic;

import com.ms_catalogos.dto.TipoTarjetaRequest;
import com.ms_catalogos.dto.TipoTarjetaResponse;
import com.ms_catalogos.entity.TipoTarjeta;
import com.ms_catalogos.mapper.TipoTarjetaMapper;
import com.ms_catalogos.repository.TipoTarjetaRepository;
import com.ms_catalogos.service.TipoTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoTarjetaLogic implements TipoTarjetaService {
    @Autowired
    TipoTarjetaRepository repo;

    @Override
    public List<TipoTarjetaResponse> mostrar() {
        List<TipoTarjetaResponse> response = new ArrayList<>();
        for(TipoTarjeta tt: repo.findAll()){
            response.add(TipoTarjetaMapper.toResponse(tt));
        }
        return response;
    }

    @Override
    public TipoTarjetaResponse guardar(TipoTarjetaRequest request) {
        TipoTarjeta tt = new TipoTarjeta();
        tt = TipoTarjetaMapper.toEntity(request);
        repo.save(tt);
        return TipoTarjetaMapper.toResponse(tt);
    }

    @Override
    public TipoTarjetaResponse buscar(int id) {
        TipoTarjeta tt = repo.findById(id).get();
        return null;
    }
}
