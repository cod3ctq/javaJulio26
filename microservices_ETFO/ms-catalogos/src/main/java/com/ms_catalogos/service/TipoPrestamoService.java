package com.ms_catalogos.service;

import com.ms_catalogos.dto.TipoPrestamoRequest;
import com.ms_catalogos.dto.TipoPrestamoResponse;

import java.util.List;

public interface TipoPrestamoService {

    List<TipoPrestamoResponse> mostrar();

    TipoPrestamoResponse guardar(TipoPrestamoRequest request);

    TipoPrestamoResponse buscarPorDescripcion(String descripcion);
    //Esta funcionalidad debera ser enrutada en el controller con el verbo PATCH
    //dentro del mismo JSON recibira el nuevo interes y el palzo, ademas el tipoPrestamoId
    TipoPrestamoResponse actualizarDatos(TipoPrestamoRequest request);

}
