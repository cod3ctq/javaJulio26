package com.ms_catalogos.service;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.entity.TipoCuenta;

import java.util.List;
import java.util.Optional;

public interface TipoCuentaService {

    List<TipoCuentaResponse> mostrar();

    TipoCuentaResponse guardar (TipoCuentaRequest request);

    TipoCuentaResponse buscar (String descripcion);

    TipoCuentaResponse buscar (int Id);

    //Realizar estos metodos tal como se hizo el UPDATE, usa tambien las anotaciones
    //@Modifying, @Transactional, @Query dentro del repository
    TipoCuentaResponse actualizarSaldoMin (String descripcion, double saldo);

    TipoCuentaResponse acutualizarSaldoMax(String descripcion, double saldo);
}

