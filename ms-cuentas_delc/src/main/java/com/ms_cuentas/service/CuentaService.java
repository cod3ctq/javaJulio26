package com.ms_cuentas.service;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.entity.Cuenta;

import java.util.List;

//interface de negocio
//aquí se diseñan las operaciones de las que este servicio se hará cargo
//los procesos de negocio de esta área de negocio
public interface CuentaService {

    CuentaResponse crearCuenta(CuentaRequest request);
    CuentaResponse buscarCuenta(int cuentaId);
    CuentaResponse buscarCuenta(String numCuenta);
    //Por motivo didactico, existe este metodo para actualizar una cuenta
    //aunque en realidad, bajo el punto de vista de negocio, no se necesita así tal cual
    CuentaResponse actualizarCuenta(CuentaRequest request);
    //por motivo didactico, ec¿xiste el metodo eliminar (fisicamente)
    //aunque en realidad, no suceda así
    String eliminar(int cuentaId);
    //lo que en realidad pasa cuando se elimina una cuenta
    //es un borrado logico (soft delete)
    String desactivarcuenta(String numCuenta);
    List mostrar();







}
