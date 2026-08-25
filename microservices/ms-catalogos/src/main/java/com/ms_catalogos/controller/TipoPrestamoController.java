package com.ms_catalogos.controller;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.dto.TipoPrestamoRequest;
import com.ms_catalogos.dto.TipoPrestamoResponse;
import com.ms_catalogos.logic.TipoCuentaLogic;
import com.ms_catalogos.logic.TipoPrestamoLogic;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/catalogos/tipoPrestamo")
public class TipoPrestamoController {

    @Autowired
    TipoPrestamoLogic service;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<TipoPrestamoResponse> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<TipoPrestamoResponse>guardar(@RequestBody TipoPrestamoRequest request){
        TipoPrestamoResponse tipoPrestamo = service.guardar(request);
        return new ResponseEntity<TipoPrestamoResponse>(tipoPrestamo, HttpStatusCode.valueOf(200));
    }

    @GetMapping("by-descripcion/{descripcion}")
    public ResponseEntity<TipoPrestamoResponse>buscarPorDescripcion(@PathVariable String descripcion){
        TipoPrestamoResponse tipoPrestamo = service.buscar(descripcion);
        return new ResponseEntity<TipoPrestamoResponse>(tipoPrestamo, HttpStatusCode.valueOf(200));
    }

//    @GetMapping("by-id/{id}")
//    public ResponseEntity<TipoPrestamoResponse>buscarPorDescripcion(@PathVariable int id){
//        TipoPrestamoResponse tipoPrestamo = service.buscar(id);
//        return new ResponseEntity<TipoCuentaResponse>(tipoPrestamo, HttpStatusCode.valueOf(200));
//    }

}
