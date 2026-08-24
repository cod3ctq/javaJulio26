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
@RequestMapping("api/v1/catalogos/tipo-cuenta")
public class TipoCuentaController {

    @Autowired
    TipoCuentaLogic service;

    @GetMapping
    public ResponseEntity<List>mostrar(){
        List<TipoCuentaResponse> list = service.mostrar();
        return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<TipoCuentaResponse>guardar(@RequestBody TipoCuentaRequest request){
        TipoCuentaResponse tc = service.guardar(request);
        return new ResponseEntity<TipoCuentaResponse>(tc, HttpStatusCode.valueOf(200));
    }

    @GetMapping("by-descripcion/{descripcion}")
    public ResponseEntity<TipoCuentaResponse>buscarPorDescripcion(@PathVariable String descripcion){
        TipoCuentaResponse tc = service.buscar(descripcion);
        return new ResponseEntity<TipoCuentaResponse>(tc, HttpStatusCode.valueOf(200));
    }

    @GetMapping("by-id/{id}")
    public ResponseEntity<TipoCuentaResponse>buscarPorTipoId(@PathVariable int id){
        TipoCuentaResponse tc = service.buscar(id);
        return new ResponseEntity<TipoCuentaResponse>(tc, HttpStatusCode.valueOf(200));
    }
}
