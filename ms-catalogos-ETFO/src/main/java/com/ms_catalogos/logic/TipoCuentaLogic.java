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
    TipoCuentaRepository tipoCuentaRepository;

    @Override
    public List<TipoCuentaResponse> mostrar() {
        List<TipoCuentaResponse> tipoCuentas = new ArrayList<TipoCuentaResponse>();
        for (TipoCuenta tipoCuenta : tipoCuentaRepository.findAll()) {
            tipoCuentas.add(TipoCuentaMapper.toResponse(tipoCuenta));
        }
        return tipoCuentas;
    }

    @Override
    public TipoCuentaResponse guardar(TipoCuentaRequest request) {
        TipoCuenta tipoCuenta = new TipoCuenta();
        tipoCuenta = TipoCuentaMapper.toEntity(request);
        tipoCuentaRepository.save(tipoCuenta);
        return TipoCuentaMapper.toResponse(tipoCuenta);
    }

    @Override
    public TipoCuentaResponse buscarPorDescripcion(String descripcion) {
        TipoCuenta tipoCuenta = tipoCuentaRepository.findByDescripcion(descripcion).get();
        return TipoCuentaMapper.toResponse(tipoCuenta);
    }

    @Override
    public TipoCuentaResponse buscarPorId(int id) {
        TipoCuenta tipoCuenta = tipoCuentaRepository.findById(id).get();
        return TipoCuentaMapper.toResponse(tipoCuenta);
    }

    @Override
    public TipoCuentaResponse actualizarSaldoMin(String descripcion) {
        return null;
    }

    @Override
    public TipoCuentaResponse actualizarSaldoMax(String descripcion) {
        return null;
    }
}
