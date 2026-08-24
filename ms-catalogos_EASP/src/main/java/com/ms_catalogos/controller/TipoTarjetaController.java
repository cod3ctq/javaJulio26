package com.ms_catalogos.controller;

import com.ms_catalogos.dto.TipoTarjetaResponse;
import com.ms_catalogos.logic.TipoTarjetaLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/v1/catalogos/tipo-tarjeta")
public class TipoTarjetaController {

    @Autowired
    TipoTarjetaLogic service;

    @GetMapping("/by-id/{id}")
    public ResponseEntity<TipoTarjetaResponse>buscarPorId(@PathVariable int id){
        TipoTarjetaResponse tipoTarjeta = service.buscar(id);
        return new ResponseEntity<TipoTarjetaResponse>(tipoTarjeta, HttpStatusCode.valueOf(200));
    }
}
