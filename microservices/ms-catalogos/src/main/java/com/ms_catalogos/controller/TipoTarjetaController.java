package com.ms_catalogos.controller;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.dto.TipoTarjetaRequest;
import com.ms_catalogos.dto.TipoTarjetaResponse;
import com.ms_catalogos.logic.TipoCuentaLogic;
import com.ms_catalogos.logic.TipoTarjetaLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/catalogos/tipoTarjeta")
public class TipoTarjetaController {

    @Autowired
    TipoTarjetaLogic service;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<TipoTarjetaResponse> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<TipoTarjetaResponse>guardar(@RequestBody TipoTarjetaRequest request){
        TipoTarjetaResponse tipoTarjeta = service.guardar(request);
        return new ResponseEntity<TipoTarjetaResponse>(tipoTarjeta, HttpStatusCode.valueOf(200));
    }

//    @GetMapping("by-descripcion/{descripcion}")
//    public ResponseEntity<TipoTarjetaResponse>buscarPorDescripcion(@PathVariable String descripcion){
//        TipoTarjetaResponse tipoTarjeta = service.buscar(descripcion);
//        return new ResponseEntity<TipoTarjetaResponse>(tipoTarjeta, HttpStatusCode.valueOf(200));
//    }

//    @GetMapping("by-id/{id}")
//    public ResponseEntity<TipoCuentaResponse>buscarPorDescripcion(@PathVariable int id){
//        TipoCuentaResponse tipoCuenta = service.buscar(id);
//        return new ResponseEntity<TipoCuentaResponse>(tipoCuenta, HttpStatusCode.valueOf(200));
//    }

}
