package com.ms_catalogos.service;

import com.ms_catalogos.dto.TipoPrestamoRequest;
import com.ms_catalogos.dto.TipoPrestamoResponse;

import java.util.List;
import java.util.Optional;

public interface TipoPrestamoService {

    List<TipoPrestamoResponse> mostrar();
    TipoPrestamoResponse guardar (TipoPrestamoRequest request);
    TipoPrestamoResponse buscar (String descripcion);

    //Esta funcionalidad debera ser enrutada en el controller con el verbo
    //PATCH deontro del mismo JSON recibira el nuevo interes y el plazo, ademas
    //del tipoPrestamoId
    TipoPrestamoResponse actualizarDato(TipoPrestamoRequest request);

}
