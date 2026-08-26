package com.ms_prestamos.controller;

import com.ms_prestamos.dto.PrestamosRequest;
import com.ms_prestamos.dto.PrestamosResponse;
import com.ms_prestamos.service.PrestamosImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/prestamos")
public class PrestamosController {

    @Autowired
    PrestamosImpl service;

    @GetMapping
    public ResponseEntity<List>mostrar(){
        List<PrestamosResponse> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<PrestamosResponse>guardar(@Valid @RequestBody PrestamosRequest request){
        PrestamosResponse prestamo = service.crearPrestamo(request);
        return new ResponseEntity<PrestamosResponse>(prestamo, HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<PrestamosResponse>actualizar(@Valid @RequestBody PrestamosRequest request){
        PrestamosResponse prestamo = service.actualizarPrestamo(request);
        return new ResponseEntity<PrestamosResponse>(prestamo, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{prestamoId}")
    public ResponseEntity<PrestamosResponse>buscar(@PathVariable int prestamoId){
        PrestamosResponse prestamo = service.buscarPrestamo(prestamoId);
        return new ResponseEntity<PrestamosResponse>(prestamo, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("/{prestamoId}")
    public ResponseEntity<String>eliminar(@PathVariable int prestamoId){
        String mensaje = service.eliminar(prestamoId);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(201));
    }
}
