package com.ms_catalogos.controller;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.logic.TipoCuentaLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/v1/catalogos/tipo-cuenta")
public class TipoCuentaController {

    @Autowired
    TipoCuentaLogic service;

    @GetMapping
    public ResponseEntity<List>mostrar(){
        List<TipoCuentaResponse> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<TipoCuentaResponse> guardar (@RequestBody TipoCuentaRequest request){
        TipoCuentaResponse tC = service.guardar(request);
        return new ResponseEntity<TipoCuentaResponse>(tC, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/by-descripcion/{descripcion}")
    public ResponseEntity<TipoCuentaResponse>buscarPorDescripcion(@PathVariable String descripcion){
        TipoCuentaResponse tipoCuenta = service.buscar(descripcion);
        return new ResponseEntity<TipoCuentaResponse>(tipoCuenta, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<TipoCuentaResponse>buscarPorId(@PathVariable int id){
        TipoCuentaResponse tipoCuenta = service.buscar(id);
        return new ResponseEntity<TipoCuentaResponse>(tipoCuenta, HttpStatusCode.valueOf(200));
    }
}
