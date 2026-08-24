package com.ms_prestamos.controller;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.service.impl.PrestamoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/prestamos")
public class PrestamoController {

    @Autowired
    PrestamoServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoResponse> buscarPorId(@PathVariable int id) {
        PrestamoResponse prestamo = service.buscarPorId(id);
        return new ResponseEntity<>(prestamo,  HttpStatusCode.valueOf(200)); // Retorna 200 OK con el JSON del préstamo
    }

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<PrestamoResponse> lista = service.mostrar();
        return new ResponseEntity<>(lista, HttpStatusCode.valueOf(200));
    }
    @PostMapping
    public ResponseEntity<PrestamoResponse> crearPrestamo(@RequestBody PrestamoRequest request){
        PrestamoResponse prestamo = service.crearPrestamo(request);
        return new ResponseEntity<PrestamoResponse>(prestamo,HttpStatusCode.valueOf(201));
    }
    @PutMapping
    public ResponseEntity<PrestamoResponse> abonarAPrestamo(@RequestBody PrestamoRequest request){
        PrestamoResponse prestamo = service.abonarAPrestamo(request.getPrestamoId(),request.getMonto());
        return new ResponseEntity<PrestamoResponse>(prestamo,HttpStatusCode.valueOf(200));
    }
}
