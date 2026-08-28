package com.ms_catalogos.logic;

import com.ms_catalogos.dto.MedioPagoResponse;
import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.entity.MedioPago;
import com.ms_catalogos.entity.TipoCuenta;
import com.ms_catalogos.mapper.MedioPagoMapper;
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
        List<TipoCuentaResponse> response = new ArrayList<TipoCuentaResponse>();
        for (TipoCuenta tC : repo.findAll()){
            response.add(TipoCuentaMapper.toResponse(tC));
        }
        return response;
    }

    @Override
    public TipoCuentaResponse guardar(TipoCuentaRequest request) {
        TipoCuenta tC = TipoCuentaMapper.toEntity(request);
        repo.save(tC);
        return TipoCuentaMapper.toResponse(tC);
    }

    @Override
    public TipoCuentaResponse buscar(String descripcion) {
        TipoCuenta tc = repo.findByDescripcionTipoCuenta(descripcion).get();
        return TipoCuentaMapper.toResponse(tc);
    }

    @Override
    public TipoCuentaResponse buscar(int tipoId) {
        TipoCuenta tc = repo.findById(tipoId).get();
        return TipoCuentaMapper.toResponse(tc);
    }

    @Override
    public TipoCuentaResponse actualizarSaldoMin(String descripcion, double saldoMin) {
        TipoCuenta tc = repo.findByDescripcionTipoCuenta(descripcion).get();

        return null;
    }

    @Override
    public TipoCuentaResponse actualizarSaldoMax(String descripcion, double saldo) {
        return null;
    }
}
