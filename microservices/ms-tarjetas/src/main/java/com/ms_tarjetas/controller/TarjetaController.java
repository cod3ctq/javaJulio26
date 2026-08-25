package com.ms_tarjetas.controller;

import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.dto.TarjetaResponse;
import com.ms_tarjetas.service.impl.TarjetaImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/tarjetas")
public class TarjetaController {
    @Autowired
    TarjetaImpl service;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<TarjetaResponse> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<TarjetaResponse> guardar(@Valid @RequestBody TarjetaRequest request){
        TarjetaResponse tarjeta = service.crearTarjeta(request);
        return new ResponseEntity<TarjetaResponse>(tarjeta, HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<TarjetaResponse> actualizar(@Valid @RequestBody TarjetaRequest request){
        TarjetaResponse tarjeta = service.actualizarTarjeta(request);
        return new ResponseEntity<TarjetaResponse>(tarjeta, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{by-tarjetaId}")
    public ResponseEntity<TarjetaResponse> buscar(@PathVariable int tarjetaId){
        TarjetaResponse tarjeta = service.buscarTarjeta(tarjetaId);
        return new ResponseEntity<TarjetaResponse>(tarjeta, HttpStatusCode.valueOf(200));
    }

    @GetMapping("by-numTarjeta/{numTarjeta}")
    public ResponseEntity<TarjetaResponse> buscarPorNumCuenta(@PathVariable String numTarjeta) {
        TarjetaResponse tarjeta = service.buscarTarjeta(numTarjeta);
        return new ResponseEntity<TarjetaResponse>(tarjeta, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{tarjetaId}")
    public ResponseEntity<String> eliminar(@PathVariable int tarjetaId){
        String mensaje = service.eliminar(tarjetaId);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("soft-delete/{numTarjeta}")
    public ResponseEntity<String> desactivar(@PathVariable String numTarjeta){
        String mensaje = service.desactivarTarjeta(numTarjeta);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @GetMapping("by-num-tarjeta/{numTarjeta}")
    public ResponseEntity<TarjetaResponse> buscar(@PathVariable String numTarjeta) {
        TarjetaResponse tarjeta = service.buscarTarjeta(numTarjeta);
        return new ResponseEntity<TarjetaResponse>(tarjeta, HttpStatusCode.valueOf(200));
    }

}
