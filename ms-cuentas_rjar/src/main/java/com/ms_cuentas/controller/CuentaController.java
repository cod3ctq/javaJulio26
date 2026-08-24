package com.ms_cuentas.controller;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.service.impl.CuentaImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cuentas") //Designa una ruta generica a nivel de controlador
public class CuentaController {

    @Autowired
    CuentaImpl service;

    @GetMapping
    public ResponseEntity<List> mostrar() {
        List<CuentaResponse> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<CuentaResponse> guardar(@Valid @RequestBody CuentaRequest request) {
        CuentaResponse cuenta = service.crearCuenta(request);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<CuentaResponse> actualizar(@Valid @RequestBody CuentaRequest request) {
        CuentaResponse cuenta = service.actualizarCuenta(request);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    //http://localhost:8090/api/v1/cuentas/12
    @GetMapping("/{cuentaId}") //es un paarmetro
    public ResponseEntity<CuentaResponse> buscar(@PathVariable int cuentaId) {
        CuentaResponse cuenta = service.buscarCuenta(cuentaId);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }
    @GetMapping("by-numCuenta/{numCuenta}") //es un paarmetro
    public ResponseEntity<CuentaResponse> buscarPorNumCuenta(@PathVariable String numCuenta) {
        CuentaResponse cuenta = service.buscarCuenta(numCuenta);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    //http://localhost:8090/api/v1/cuentas
    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<String> eliminar(@PathVariable int cuentaId) {
        String mensaje = service.eliminar(cuentaId);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));

    }

    @DeleteMapping("soft-delete/{numCuenta}")
    public ResponseEntity<String> desactivar(@PathVariable String numCuenta) {
        String mensaje = service.desactivarCuenta(numCuenta);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
}
