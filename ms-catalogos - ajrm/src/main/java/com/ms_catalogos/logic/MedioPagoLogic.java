package com.ms_catalogos.logic;

import com.ms_catalogos.dto.MedioPagoRequest;
import com.ms_catalogos.dto.MedioPagoResponse;
import com.ms_catalogos.entity.MedioPago;
import com.ms_catalogos.mapper.MedioPagoMapper;
import com.ms_catalogos.repository.MedioPagoRepository;
import com.ms_catalogos.service.MedioPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedioPagoLogic implements MedioPagoService {

    @Autowired
    MedioPagoRepository repo;

    @Override
    public List<MedioPagoResponse> mostrar() {
        List<MedioPagoResponse> response = new ArrayList<MedioPagoResponse>();
        for (MedioPago mp : repo.findAll()){
            response.add(MedioPagoMapper.toResponse(mp));
        }
        return response;
    }

    @Override
    public MedioPagoResponse guardar(MedioPagoRequest request) {
        MedioPago mP = MedioPagoMapper.toEntity(request);
        repo.save(mP);
        return MedioPagoMapper.toResponse(mP);
    }

    @Override
    public MedioPagoResponse buscar(String descripcion) {
        MedioPago mp = repo.findByDescripcion(descripcion).get();
        return MedioPagoMapper.toResponse(mp);
    }


}

