package com.ms_cuentas.controller;

import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cuentas")//Designa un a ruta generica a nivel de controlador
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<CuentaResponse> lista = cuentaService.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<CuentaResponse> guardar(@Valid @RequestBody CuentaRequest request){
        CuentaResponse cuenta = cuentaService.crearCuenta(request);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(201));
    }
    //Esta configurado para que desde el JSON se inserte el id de la cuenta para que lo reconozca
    @PutMapping
    public ResponseEntity<CuentaResponse> actualizar(@Valid @RequestBody CuentaRequest request){
        CuentaResponse cuenta = cuentaService.actualizarCuenta(request);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{cuentaId}")
    public ResponseEntity<CuentaResponse> buscar(@Valid @PathVariable int cuentaId){
        CuentaResponse cuenta = cuentaService.buscarCuenta(cuentaId);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @GetMapping("by-numCuenta/{numCuenta}")
    public ResponseEntity<CuentaResponse> buscar(@PathVariable String numCuenta){
        CuentaResponse cuenta = cuentaService.buscarCuenta(numCuenta);
        return new ResponseEntity<CuentaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<String> eliminar(@PathVariable int cuentaId){
        String mensaje = cuentaService.eliminar(cuentaId);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("soft-delete/{numCuenta}")
    public ResponseEntity<String> eliminar(@PathVariable String numCuenta){
        String mensaje = cuentaService.desactivarCuenta(numCuenta);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
}
