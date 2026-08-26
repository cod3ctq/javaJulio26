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
@RequestMapping ("api/v1/cuentas") //Designa una ruta generica a nivel de controlador
public class CuentaController {

    @Autowired
    CuentaImpl service;

    @GetMapping //Solicita ver o leer datos del servidor
    public ResponseEntity<List> mostrar(){
        List<CuentaResponse> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping //Envia datos nuevos al servidor
    public ResponseEntity<CuentaResponse> guardar (@Valid @RequestBody CuentaRequest request){
        //@RequestBody indica al servidor que estas enviando datos en el cuerpo de la peticion
        CuentaResponse cuenta = service.crearCuenta(request);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<CuentaResponse> actualizar (@Valid @RequestBody CuentaRequest request) {
        CuentaResponse cuenta = service.actualizarCuenta(request);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @GetMapping ("/{cuentaId}")
    public ResponseEntity<CuentaResponse> buscar (@PathVariable int cuentaId) {
        //@PathVariable indica al servidor que estas enviando una variable en la URL y de esta forma puedan ser manipulados
        CuentaResponse cuenta = service.buscarCuenta(cuentaId);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @GetMapping ("/by-numCuenta/{numCuenta}")
    public ResponseEntity<CuentaResponse> buscarPorNumCuenta (@PathVariable String numCuenta) {
        CuentaResponse cuenta = service.buscarCuenta(numCuenta);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<String> eliminar (@PathVariable int cuentaId) {
        String mensaje = service.eliminar(cuentaId);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("soft-delete/{numCuenta}")
    public ResponseEntity<String> desactivar (@PathVariable String numCuenta) {
        String mensaje = service.desactivarCuenta(numCuenta);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }


}
