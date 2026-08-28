package com.ms_tarjetas.mapper;

import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.dto.TarjetaResponse;
import com.ms_tarjetas.entity.Tarjeta;
import com.ms_tarjetas.util.TarjetaHelper;

import java.time.LocalDate;

public class TarjetaMapper {

    public static Tarjeta toEntity (TarjetaRequest request){
        Tarjeta tarjeta = new Tarjeta();

        tarjeta.setCuentaId(request.getCuentaId());
        tarjeta.setTipoTarjetaId(request.getTipoTarjetaId());
        tarjeta.setNumTarjeta(TarjetaHelper.generarNumTarjeta());
        tarjeta.setNip(TarjetaHelper.generarNip());
        tarjeta.setFechaVen(LocalDate.now().plusYears(5));
        tarjeta.setStatus("ACTIVO");

        return tarjeta;
    }

    public static TarjetaResponse toResponse (Tarjeta tarjeta){
        return new TarjetaResponse(tarjeta.getTarjetaId(),
                tarjeta.getCuentaId(),
                tarjeta.getTipoTarjetaId(),
                tarjeta.getNumTarjeta(),
                tarjeta.getFechaVen());
    }

    public static Tarjeta toUpdateTarjeta (Tarjeta old, TarjetaRequest request){

        old.setCuentaId(request.getCuentaId());
        old.setTipoTarjetaId(request.getTipoTarjetaId());
        old.setNumTarjeta(TarjetaHelper.generarNumTarjeta());
        old.setNip(TarjetaHelper.generarNip());
        old.setFechaVen(LocalDate.now().plusYears(5));
        old.setStatus("ACTIVO");
        return old;
    }
}
