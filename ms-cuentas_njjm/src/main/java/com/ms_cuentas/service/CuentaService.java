package com.ms_cuentas.service;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.entity.Cuenta;

import java.util.List;

//Interface de negocio:
//Aquí se diseñan las operaciones de las que ste servicio se hará cargo
//los procesos de negocio de esta área de negocio
public interface CuentaService {

    CuentaResponse crearCuenta(CuentaRequest request);
    CuentaResponse buscarCuenta(int cuentaId);
    CuentaResponse buscarCuenta(String numCuenta);
    //Por motivo didáctico, existe este método para actualizar una cuenta
    //aunque en realidad, bajo el punto de vista de negocio, no se necesite así tal cual
    CuentaResponse actualizarCuenta(CuentaRequest request);
    //Por motivo didáctico, existe el método eliminar (físicamente)
    //Aunque en realidad, no sucede así
    String eliminar(int cuentaId);

    //Lo que en realidad pasa cuando se elimina una cuenta
    //es un borrado lógico (soft delete)
    String desactivarCuenta(String numCuenta);
    List mostrar();

}
