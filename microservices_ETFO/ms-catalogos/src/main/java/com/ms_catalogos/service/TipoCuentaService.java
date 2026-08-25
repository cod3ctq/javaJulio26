package com.ms_catalogos.service;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;

import java.util.List;

public interface TipoCuentaService {

    List<TipoCuentaResponse> mostrar();

    TipoCuentaResponse guardar(TipoCuentaRequest request);

    TipoCuentaResponse buscarPorDescripcion(String descripcion);

    TipoCuentaResponse buscarPorId(int id);

    //Realizar estos metodos tal como se hizo el UPDATE, usa tambien las anotaciones
    //@Modifying, @Transactional, @Query dentro del repository
    TipoCuentaResponse actualizarSaldoMin(String descripcion);

    TipoCuentaResponse actualizarSaldoMax(String descripcion);

}
