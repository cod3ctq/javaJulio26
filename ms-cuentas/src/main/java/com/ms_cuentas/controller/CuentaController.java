package com.ms_cuentas.controller;


import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.service.impl.CuentaImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cuentas") //Designa una ruta generica a nivel de controlador /Afecta a todos los metodos de aca
public class CuentaController {

    @Autowired
    CuentaImpl service;


    @GetMapping //Solo sirve para obtener informacion, en este caso el codigo sirve para
    // sacar una lista de datos y nos da devuelve desde el servidor
    public ResponseEntity<List> mostrar(){ //ResponseEntity es un envoltorio
        List<CuentaResponse> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping //Crear un nuevo recurso, la peticion sale de mi curso y sirve para llevar o cargar
    // nuevos datos al servidor
    //Para que el servidor sepa que le estas pidiendo datos a cerca de la peticion se coloca el RequestBody
    public ResponseEntity<CuentaResponse> guardar(@Valid @RequestBody CuentaRequest request){ //todo lo que devuelve el servidor es un response
        CuentaResponse cuenta = service.crearCuenta(request); //La peticion del cliente es un request
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(201));
    }

    @PutMapping //
    public ResponseEntity<CuentaResponse> actualizar(@Valid @RequestBody CuentaRequest request){//
        CuentaResponse cuenta = service.actualizarCuenta(request);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    //http://localhost:8090/api/v1/cuentas/12
    @GetMapping("/{cuentaId}")
    public ResponseEntity<CuentaResponse> buscar(@PathVariable int cuentaId){
        CuentaResponse cuenta = service.buscarCuenta(cuentaId);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<String> eliminar(@PathVariable int cuentaId){
        String mensaje = service.eliminar(cuentaId);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }


    @DeleteMapping("soft-delete/{numCuenta}")
    public ResponseEntity<String> desactivar(@PathVariable String numCuenta){
        String mensaje = service.desactivarCuenta(numCuenta);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @GetMapping("by-numCuenta/{cuentaId}")
    public ResponseEntity<CuentaResponse> buscarPorNumCuenta(@PathVariable String numCuenta){
        CuentaResponse cuenta = service.buscarCuenta(numCuenta);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

}
