package com.ms_catalogos.controller;

import com.ms_catalogos.dto.TipoCuentaRequest;
import com.ms_catalogos.dto.TipoCuentaResponse;
import com.ms_catalogos.logic.TipoCuentaLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/catalogos/tipo-cuenta")
public class TipoCuentaController {

    @Autowired
    TipoCuentaLogic tipoCuentaService;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<TipoCuentaResponse> lista = tipoCuentaService.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<TipoCuentaResponse>guardar(@RequestBody TipoCuentaRequest request){
        TipoCuentaResponse tipoCuenta = tipoCuentaService.guardar(request);
        return new ResponseEntity<TipoCuentaResponse>(tipoCuenta, HttpStatusCode.valueOf(200));
    }

    @GetMapping("by-descripcion/{descripcion}")
    public ResponseEntity<TipoCuentaResponse>buscarPorDescripcion(@PathVariable String descripcion){
        TipoCuentaResponse tipoCuenta = tipoCuentaService.buscarPorDescripcion(descripcion);
        return new ResponseEntity<TipoCuentaResponse>(tipoCuenta, HttpStatusCode.valueOf(200));
    }

    @GetMapping("by-id/{id}")
    public ResponseEntity<TipoCuentaResponse>buscarPorId(@PathVariable int id){
        TipoCuentaResponse tipoCuenta = tipoCuentaService.buscarPorId(id);
        return new ResponseEntity<TipoCuentaResponse>(tipoCuenta, HttpStatusCode.valueOf(200));
    }

}
