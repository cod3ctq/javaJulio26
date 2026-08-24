package com.ms_tarjetas.service.impl;

import com.ms_tarjetas.constants.Mensajes;
import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.dto.TarjetaResponse;
import com.ms_tarjetas.entity.Tarjeta;
import com.ms_tarjetas.exception.AccountWithAlreadyRegisteredCard;
import com.ms_tarjetas.exception.BusinessException;
import com.ms_tarjetas.exception.NotExistException;
import com.ms_tarjetas.mapper.TarjetaMapper;
import com.ms_tarjetas.repository.TarjetaRepository;
import com.ms_tarjetas.service.TarjetaService;
import com.ms_tarjetas.util.TarjetaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TarjetaImpl implements TarjetaService {

    @Autowired
    TarjetaRepository repo;


    @Override
    public TarjetaResponse crearTarjeta(TarjetaRequest request) {


        if(repo.getAllCards(request.getCuentaId()).isPresent()){
            throw new AccountWithAlreadyRegisteredCard(Mensajes.ALREADY_REGISTERED_CARD);
        }else{
            Tarjeta tarjeta = TarjetaMapper.toEntity(request);

            repo.save(tarjeta);

            return TarjetaMapper.toResponse(tarjeta);
        }


    }

    @Override
    public TarjetaResponse buscarTarjeta(int tarjetaId) {
        Optional<Tarjeta> tarjeta = repo.findActiveById(tarjetaId);

        if(tarjeta.isPresent()){
            return TarjetaMapper.toResponse(tarjeta.get());
        }else{
            throw new NotExistException(Mensajes.NOT_EXIST);
        }

    }

    @Override
    public TarjetaResponse buscarTarjeta(String numTarjeta) {
        Optional<Tarjeta> tarjeta = repo.findByNumTarjeta(numTarjeta);

        if(numTarjeta.length()!=16){
            throw new BusinessException(Mensajes.INVALID_CARD_NUMBER);
        }else if(tarjeta.isEmpty()){
            throw new NotExistException(Mensajes.NOT_EXIST);
        }else {
            return TarjetaMapper.toResponse(tarjeta.get());
        }

    }

    @Override
    public TarjetaResponse actualizarTarjeta(TarjetaRequest request) {
        Tarjeta tarjeta =repo.findById(request.getTarjetaId()).get();

        tarjeta = TarjetaMapper.toUpdateEntity(tarjeta,request);

        repo.save(tarjeta);

        return TarjetaMapper.toResponse(tarjeta);
    }

    @Override
    public String eliminar(int tarjetaId) {
        repo.deleteById(tarjetaId);
        return "Tarjeta eliminada";
    }

    @Override
    public String desactivarTarjeta(String numTarjerta) {
        repo.actualizarStatus("BLOQUEADO",numTarjerta);
        return "Cuenta eliminada";
    }

    @Override
    public List mostrar() {
        List<TarjetaResponse> response = new ArrayList<TarjetaResponse>();
        for(Tarjeta t: repo.getActiveAccounts().get()){
            response.add(TarjetaMapper.toResponse(t));
        }
        return response;
    }
}
