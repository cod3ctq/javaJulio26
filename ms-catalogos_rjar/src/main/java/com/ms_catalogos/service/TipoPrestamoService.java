package com.ms_catalogos.service;

import com.ms_catalogos.dto.MedioPagoRequest;
import com.ms_catalogos.dto.MedioPagoResponse;
import com.ms_catalogos.dto.TipoPrestamoRequest;
import com.ms_catalogos.dto.TipoPrestamoResponse;

import java.util.List;

public interface TipoPrestamoService {

    List<TipoPrestamoResponse> mostrar();
    TipoPrestamoResponse  guardar(TipoPrestamoRequest request);
    TipoPrestamoResponse buscar(String descripcion);

    //Esta funcionalidad debera ser enrutada en el controller con el verbo PATCH
    //dentro del mismo JSON recibira el nuevo interes y el plazo, ademas del
    //tipoPrestamoId
    TipoPrestamoResponse actualizaDatos(TipoPrestamoRequest request);
}
