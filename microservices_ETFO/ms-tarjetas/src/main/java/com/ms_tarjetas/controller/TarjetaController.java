package com.ms_tarjetas.controller;

import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.dto.TarjetaResponse;
import com.ms_tarjetas.service.TarjetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/tarjetas")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<TarjetaResponse> lista = tarjetaService.verTarjetas();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<TarjetaResponse> guardar(@Valid @RequestBody TarjetaRequest request){
        TarjetaResponse cuenta = tarjetaService.crearTarjeta(request);
        return new ResponseEntity<TarjetaResponse>(cuenta, HttpStatusCode.valueOf(201));
    }
    //Esta configurado para que desde el JSON se inserte el id de la cuenta para que lo reconozca
    @PutMapping
    public ResponseEntity<TarjetaResponse> actualizar(@Valid @RequestBody TarjetaRequest request){
        TarjetaResponse cuenta = tarjetaService.actualizarTarjeta(request);
        return new ResponseEntity<TarjetaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{tarjetaId}")
    public ResponseEntity<TarjetaResponse> buscar(@PathVariable int tarjetaId){
        TarjetaResponse cuenta = tarjetaService.obtenerTarjetaPorId(tarjetaId);
        return new ResponseEntity<TarjetaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @GetMapping("num-tarjeta/{numTarjeta}")
    public ResponseEntity<TarjetaResponse> buscar(@PathVariable String numTarjeta){
        TarjetaResponse cuenta = tarjetaService.obtenerTarjetaPorNumTarjeta(numTarjeta);
        return new ResponseEntity<TarjetaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{tarjetaId}")
    public ResponseEntity<String> eliminar(@PathVariable int tarjetaId){
        String mensaje = tarjetaService.eliminarTarjeta(tarjetaId);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

}
