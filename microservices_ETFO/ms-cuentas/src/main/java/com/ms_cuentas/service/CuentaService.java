package com.ms_cuentas.service;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;

import java.util.List;

public interface CuentaService {

    //El dto nos ayuda a pedir los datos y al final nos regresa la entidad, no se debe de hacer asi, debe haber un response
    //Cuenta crearCuenta(CuentaRequest request);

    CuentaResponse crearCuenta(CuentaRequest cuentaRequest);
    CuentaResponse buscarCuenta(int cuentaId);
    CuentaResponse buscarCuenta(String numCuenta);
    //Por motivo didactico, existe este metodo para actualizar una cuenta
    //Aunque en realidad, bajo el punto de vista de negocio, no se necesita asi tal cual.
    CuentaResponse actualizarCuenta(CuentaRequest cuentaRequest);
    //Por motivo didactico, existe el metodo eliminar (físicamente)
    //Aunque en realidad, no sucede asi
    String eliminar(int cuentaId);
    //Lo que en realidad pasa cuando se elimina una cuenta
    // es un borrado logico(soft delete)
    String desactivarCuenta(String numCuenta);
    List mostrar();
}
