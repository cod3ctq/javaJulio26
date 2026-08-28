package com.ms_cuentas.service;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;

import java.util.List;

//Iterface de negocio:
//aqui se diseñan las operaciones de las que este servicio se hara cargo,
//los procesos de negocio de esta area de negocio
public interface CuentaService {

    CuentaResponse crearCuenta(CuentaRequest request);
    CuentaResponse buscarCuenta(int cuentaId);
    CuentaResponse buscarCuenta(String numCuenta);
    //Por motivo didactico, existe este medo para actualizar una cuenta
    //aunque en realidad, bajo el punto de vista de negocio, no se necsite asi tal cual
    CuentaResponse actualizarCuenta(CuentaRequest request);
    //por motivo didactico, existe el metodo eliminar (fisicamente)
    //Aunque en realidad, no suceda asi
    String eliminar(int cuentaId);
    //Lo que en realiadad pasa cuando se elimina una cuenta
    //es un birrado logico (soft delete)
    String desactivarCuenta(String numCuenta);
    List mostrar ();

}
