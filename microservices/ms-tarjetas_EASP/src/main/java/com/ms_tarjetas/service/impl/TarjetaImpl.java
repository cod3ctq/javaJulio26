package com.ms_tarjetas.service.impl;

import com.ms_tarjetas.constants.Mensajes;
import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.dto.TarjetaResponse;
import com.ms_tarjetas.dto.TipoTarjetaRecord;
import com.ms_tarjetas.entity.Tarjeta;
import com.ms_tarjetas.exception.AccountAlreadyHasCardException;
import com.ms_tarjetas.exception.BussinessException;
import com.ms_tarjetas.exception.DoesNotExistCardException;
import com.ms_tarjetas.mapper.TarjetaMapper;
import com.ms_tarjetas.repository.TarjetaRepository;
import com.ms_tarjetas.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TarjetaImpl implements TarjetaService {

    @Autowired
    TarjetaRepository repo;
    RestTemplate http = new RestTemplate();

    @Override
    public TarjetaResponse nuevaTarjeta(TarjetaRequest request) {
        TipoTarjetaRecord record =
                http.getForObject("http://localhost:8092/api/v1/catalogos/tipo-tarjeta/by-id/" + request.getTipoTarjetaId(),
                        TipoTarjetaRecord.class);
        TarjetaResponse response = null;

        if (repo.getCardByAccount(request.getCuentaId()).isPresent()){
            throw new AccountAlreadyHasCardException(Mensajes.ACCOUNT_ALREADY_HAS_CARD);
        }else {
            Tarjeta tarjeta = TarjetaMapper.toEntity(request);

            repo.save(tarjeta);

            response = TarjetaMapper.toResponse(tarjeta);
        }
        return response;
    }

    @Override
    public TarjetaResponse buscarTarjeta(int tarjetaId) {
        Optional<Tarjeta> tarjeta = repo.findByActiveCards(tarjetaId);

        if(tarjeta.isPresent()) {
            return TarjetaMapper.toResponse(tarjeta.get());
        }else {
            throw new DoesNotExistCardException(Mensajes.DOES_NOT_EXIST_CARD);
        }
    }

    @Override
    public TarjetaResponse buscarTarjeta(String numTarjeta) {
        Optional<Tarjeta> tarjeta = repo.findByNumTarjeta(numTarjeta);

        if (numTarjeta.length()!=16){
            throw new BussinessException(Mensajes.INVALID_CARD_NUMBER);
        }else if (tarjeta.isEmpty()){
            throw new DoesNotExistCardException(Mensajes.DOES_NOT_EXIST_CARD);
        }else {
            return TarjetaMapper.toResponse(tarjeta.get());
        }
    }

    @Override
    public TarjetaResponse actualizarTarjeta(TarjetaRequest request) {
        Tarjeta tarjeta = repo.findById(request.getTarjetaId()).get();

        tarjeta = TarjetaMapper.toUpdateTarjeta(tarjeta, request);

        repo.save(tarjeta);

        return TarjetaMapper.toResponse(tarjeta);
    }

    @Override
    public String eliminar(int tarjetaId) {

        repo.deleteById(tarjetaId);
        return "Tarjeta eliminada";
    }

    @Override
    public String desactivarTarjeta(String numTarjeta) {

        return "";
    }

    @Override
    public List mostrar() {

        List<TarjetaResponse> response = new ArrayList<TarjetaResponse>();
        for (Tarjeta t: repo.findAll()){
            response.add(TarjetaMapper.toResponse(t));
        }
        return response;
    }
}
