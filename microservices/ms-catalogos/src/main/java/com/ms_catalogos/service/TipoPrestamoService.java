package com.ms_catalogos.service;

import com.ms_catalogos.dto.TipoPrestamoRequest;
import com.ms_catalogos.dto.TipoPrestamoResponse;

import java.util.List;
import java.util.Optional;

public interface TipoPrestamoService {
    List<TipoPrestamoResponse> mostrar();
    TipoPrestamoResponse guardar(TipoPrestamoRequest request);
    TipoPrestamoResponse buscar(String descripcion);

    //Esta funcionalidad deberá se enrutada en el controller con el verbo PATCH dentro del mismo JSON recibirá el nuevo
    //interés y el plazo, además del tipoPrestamoId
    TipoPrestamoResponse actualizarDatos(TipoPrestamoRequest request);
}
