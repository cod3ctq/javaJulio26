package com.ms_catalogos.service;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.entity.TipoCuenta;

import java.util.List;
import java.util.Optional;

public interface TipoCuentaService {
    List<TipoCuentaResponse> mostrar();
    TipoCuentaResponse guardar(TipoCuentaRequest request);
    TipoCuentaResponse buscar(String descripcion);
    TipoCuentaResponse buscar(int tipoId);

    //Realizar estos métodos tal como se hizo el UPDATE, usa también las anotaciones
    //@Modifying, @Transactional, @Query dentro del repository
    TipoCuentaResponse actualizarSaldoMin(String descripcion, double saldo);
    TipoCuentaResponse actualizarSaldoMax(String descripcion, double saldo);
}
