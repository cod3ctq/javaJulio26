package com.ms_tarjetas.service.impl;

import com.ms_tarjetas.constants.Mensajes;
import com.ms_tarjetas.dto.CuentaRecord;
import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.dto.TarjetaResponse;
import com.ms_tarjetas.entity.Tarjeta;
import com.ms_tarjetas.exception.*;
import com.ms_tarjetas.mapper.TarjetaMapper;
import com.ms_tarjetas.repository.TarjetaRepository;
import com.ms_tarjetas.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarjetaServiceImpl implements TarjetaService {

    @Autowired
    TarjetaRepository tarjetaRepository;

    RestTemplate http = new RestTemplate();

    @Override
    public TarjetaResponse crearTarjeta(TarjetaRequest request) {

        try {
            CuentaRecord cuentaRecord = http.getForObject(
                    "http://localhost:8091/api/v1/cuentas/"
                            + request.getCuentaId(),
                    CuentaRecord.class
            );

        } catch (AccountNotExistException ex) {
            throw new AccountNotExistException(
                    Mensajes.ACCOUNT_NOT_EXIST
            );
        }

        if(tarjetaRepository.getTipoTarjetaById(request.getTipoTarjetaId()).isEmpty()) {
            throw new CardTypeNotFoundException(Mensajes.CARD_TYPE_NOT_FOUND);
        } else if (tarjetaRepository.hasCard(request.getCuentaId()).isPresent()) {
            throw new AccountAlreadyHasCardException(
                    Mensajes.ACCOUNT_ALREADY_HAS_CARD
            );
        }

        Tarjeta tarjeta = TarjetaMapper.toEntity(request);

        tarjetaRepository.save(tarjeta);

        return TarjetaMapper.toResponse(tarjeta);
    }

    @Override
    public List verTarjetas() {
        List<TarjetaResponse> tarjetasResponse = new ArrayList<>();
        for (Tarjeta tarjeta : tarjetaRepository.findAll()) {
            tarjetasResponse.add(TarjetaMapper.toResponse(tarjeta));
        }
        return tarjetasResponse;
    }

    @Override
    public TarjetaResponse actualizarTarjeta(TarjetaRequest request) {
        Tarjeta tarjeta = tarjetaRepository.findById(request.getTarjetaId()).get();
        TarjetaResponse tarjetaResponse = null;
        if(request.getCuentaId() != tarjeta.getCuentaId()) {
            throw new CardAlreadyAssignedToAccountException(Mensajes.CARD_ALREADY_ASSIGNED_TO_ACCOUNT);
        } else {
            tarjeta.setTipoTarjetaId(request.getTipoTarjetaId());
            tarjetaRepository.save(tarjeta);
            tarjetaResponse = TarjetaMapper.toResponse(tarjeta);
        }
        return tarjetaResponse;
    }

    @Override
    public String eliminarTarjeta(int tarjetaId) {
        tarjetaRepository.deleteById(tarjetaId);
        return "Tarjeta eliminada exitosamente";
    }

    @Override
    public TarjetaResponse obtenerTarjetaPorId(int tarjetaId) {
        Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId).get();

        return TarjetaMapper.toResponse(tarjeta);
    }

    @Override
    public TarjetaResponse obtenerTarjetaPorNumTarjeta(String numTarjeta) {
        Tarjeta tarjeta = tarjetaRepository.findByNumTarjeta(numTarjeta).get();
        if (tarjeta.getNumTarjeta()==null) {
            throw new CardNotFoundException(Mensajes.CARD_NOT_FOUND);
        } else if (numTarjeta.length()!=16){
            throw new InvalidCardNumberDigitsException(Mensajes.INVALID_CARD_NUMBER_DIGITS);
        } else if (tarjeta.getStatus().equals("BLOQUEADO")) {
            throw new CardBlockedException(Mensajes.CARD_BLOCKED);
        } else if (tarjeta.getStatus().equals("DESACTIVADO")) {
            throw new CardDisabledException(Mensajes.CARD_DISABLED);
        } else {
            return TarjetaMapper.toResponse(tarjeta);
        }
    }
}
