package com.ms_tarjetas.mapper;

import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.dto.TarjetaResponse;
import com.ms_tarjetas.entity.Tarjeta;
import com.ms_tarjetas.util.TarjetaHelper;

import java.time.LocalDate;

public class TarjetaMapper {

    public static Tarjeta toEntity(TarjetaRequest tarjetaRequest) {
        Tarjeta tarjeta = new Tarjeta();

        tarjeta.setTarjetaId(tarjetaRequest.getTarjetaId());
        tarjeta.setCuentaId(tarjetaRequest.getCuentaId());
        tarjeta.setTipoTarjetaId(tarjetaRequest.getTipoTarjetaId());
        tarjeta.setNumTarjeta(TarjetaHelper.generarNumTarjeta());
        tarjeta.setNip(TarjetaHelper.generarNip());
        tarjeta.setFechaVen(TarjetaHelper.generarFechaVen(LocalDate.now()));
        tarjeta.setStatus("ACTIVO");

        return tarjeta;
    }

    public static TarjetaResponse toResponse(Tarjeta tarjeta) {
        return new TarjetaResponse
                (
                        tarjeta.getCuentaId(),
                        tarjeta.getTipoTarjetaId(),
                        tarjeta.getNumTarjeta(),
                        tarjeta.getFechaVen()
                );
    }
}
