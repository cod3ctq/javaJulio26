package com.ms_catalogos.logic;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.entity.TipoCuenta;
import com.ms_catalogos.mapper.TipoCuentaMapper;
import com.ms_catalogos.repository.TipoCuentaRepository;
import com.ms_catalogos.service.TipoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TipoCuentaLogic implements TipoCuentaService {

    @Autowired
    TipoCuentaRepository repo;

    @Override
    public List<TipoCuentaResponse> mostrar() {
        List<TipoCuentaResponse> response = new ArrayList<>();
        for(TipoCuenta tc: repo.findAll()){
            response.add(TipoCuentaMapper.toResponse(tc));
        }
        return response;
    }

    @Override
    public TipoCuentaResponse guardar(TipoCuentaRequest request) {
        TipoCuenta tc = new TipoCuenta();
        tc = TipoCuentaMapper.toEntity(request);
        repo.save(tc);
        return TipoCuentaMapper.toResponse(tc);
    }

    @Override
    public TipoCuentaResponse buscar(String descripcion) {
        TipoCuenta tc = repo.findByDescripcon(descripcion).get();
        return TipoCuentaMapper.toResponse(tc);
    }

    @Override
    public TipoCuentaResponse buscar(int Id) {
        TipoCuenta tc = repo.findById(Id).get();
        return TipoCuentaMapper.toResponse(tc);
    }

    @Override
    public TipoCuentaResponse actualizarSaldoMin(String descripcion, double saldo) {


        return null;
    }

    @Override
    public TipoCuentaResponse acutualizarSaldoMax(String descripcion, double saldo) {


        return null;
    }
}


