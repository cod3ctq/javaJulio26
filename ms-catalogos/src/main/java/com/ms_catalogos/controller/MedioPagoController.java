package com.ms_catalogos.controller;


import com.ms_catalogos.dto.MedioPagoRequest;
import com.ms_catalogos.dto.MedioPagoResponse;
import com.ms_catalogos.logic.MedioPagoLogic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/catalogos/medio")
public class MedioPagoController {

    @Autowired
    MedioPagoLogic service;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<MedioPagoResponse> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<MedioPagoResponse>guardar(@Valid @RequestBody MedioPagoRequest request){
        MedioPagoResponse medio = service.guardar(request);
        return new ResponseEntity<MedioPagoResponse>(medio, HttpStatusCode.valueOf(200));
    }

    @GetMapping("by-descripcion/{descripcion}")
    public ResponseEntity<MedioPagoResponse>buscarPorDescripcion(@PathVariable String descripcion){
        MedioPagoResponse medio = service.buscar(descripcion);
        return new ResponseEntity<MedioPagoResponse>(medio, HttpStatusCode.valueOf(200));
    }


}
