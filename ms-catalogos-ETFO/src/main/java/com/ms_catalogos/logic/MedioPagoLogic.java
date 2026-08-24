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
    MedioPagoRepository medioPagoRepository;

    MedioPagoService medioPagoService;
    @Override
    public List<MedioPagoResponse> mostrar() {
        List<MedioPagoResponse> medioPagos = new ArrayList<MedioPagoResponse>();
        for (MedioPago medioPago : medioPagoRepository.findAll()) {
            medioPagos.add(MedioPagoMapper.toResponse(medioPago));
        }
        return medioPagos;
    }

    @Override
    public MedioPagoResponse guardar(MedioPagoRequest request) {
        MedioPago mP = MedioPagoMapper.toEntity(request);
        medioPagoRepository.save(mP);
        return MedioPagoMapper.toResponse(mP);
    }

    @Override
    public MedioPagoResponse buscarPorDescripcion(String descripcion) {
        MedioPago mp = medioPagoRepository.findByDescripcionMedioPago(descripcion).get();
        return MedioPagoMapper.toResponse(mp);
    }

    @Override
    public String eliminar(int medioId) {
        medioPagoRepository.deleteById(medioId);
        return "Cuenta eliminada";
    }
}
