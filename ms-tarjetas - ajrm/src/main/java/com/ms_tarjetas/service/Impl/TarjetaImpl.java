package com.ms_tarjetas.service.Impl;


import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.dto.TarjetaResponse;
import com.ms_tarjetas.entity.Tarjetas;
import com.ms_tarjetas.repository.TarjetasRepository;
import com.ms_tarjetas.service.TarjetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarjetaImpl implements TarjetasService {


    @Autowired
    TarjetasRepository repo;


    @Override
    public TarjetaResponse crearTarjeta(TarjetaRequest request) {

        Tarjetas tarjeta = new Tarjetas();

        tarjeta.setTipoTarjetaId(request.getTipoTarjetaId());
        tarjeta.setNumTarjeta(request.getNumTarjeta());
        tarjeta.setFechaVen(request.getFechaVen());

        repo.save(tarjeta);

        TarjetaResponse response = new TarjetaResponse(
                tarjeta.getTarjetaId(),
                tarjeta.getNumTarjeta(),
                tarjeta.getTipoTarjetaId(),
                tarjeta.getNumTarjeta(),
                tarjeta.getNip(),
                tarjeta.getFechaVen(),
                tarjeta.getStatus()
        );
        return response;
    }

    @Override
    public TarjetaResponse buscarTarjeta(int tarjetaId) {

        Tarjetas tarjeta = repo.findById(tarjetaId).get();

        TarjetaResponse response = new TarjetaResponse(
                tarjeta.getTarjetaId(),
                tarjeta.getNumTarjeta(),
                tarjeta.getTipoTarjetaId(),
                tarjeta.getNumTarjeta(),
                tarjeta.getNip(),
                tarjeta.getFechaVen(),
                tarjeta.getStatus()
        );
        return response;
    }

    @Override
    public TarjetaResponse buscarTarjeta(String numCuenta) {return null;}

    @Override
    public TarjetaResponse buscarTarjeta() {return null;}

    @Override
    public TarjetaResponse actualizarTarjeta(TarjetaRequest request) {

        Tarjetas tarjeta = repo.findById(request.getTarjetaId).get();

                tarjeta.setTarjetaId(request.getTarjetaId);
                tarjeta.setCuentaId(request.getCuentaId);
                tarjeta.setStatus(request.getStatus);







        repo.save(tarjeta);

        TarjetaResponse response = new TarjetaResponse(
                tarjeta.getTarjetaId(),
                tarjeta.getNumTarjeta(),
                tarjeta.getTipoTarjetaId(),
                tarjeta.getNumTarjeta(),
                tarjeta.getNip(),
                tarjeta.getFechaVen(),
                tarjeta.getStatus()
        );
        return response;
    }

    @Override
    public String eliminar(int tarjetaId) {

        repo.deleteById(tarjetaId);
        return "Cuenta Eliminada";
    }

    @Override
    public String desactivartarjeta(String numTarjeta) {
        return "";
    }

    @Override
    public List mostrar() {

        List<TarjetaResponse> response = new ArrayList<TarjetaResponse>();
        for(Tarjetas c:repo.findAll()){
            response.add(new TarjetaResponse(
                    c.getTarjetaId(),
                    c.getCuentaId(),
                    c.getTipoTarjetaId(),
                    c.getNumTarjeta(),
                    c.getFechaVen(),
                    c.getStatus());
        }
        return response;

    }
}
