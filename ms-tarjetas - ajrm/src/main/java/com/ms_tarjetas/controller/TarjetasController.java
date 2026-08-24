package com.ms_tarjetas.controller;


import com.ms_tarjetas.dto.TarjetaRequest;
import com.ms_tarjetas.service.Impl.TarjetaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tarjetas")
public class TarjetasController {

    @Autowired
    TarjetaImpl service;

    @GetMapping //Solo sirve para obtener informacion, en este caso el codigo sirve para
    // sacar una lista de datos y nos da devuelve desde el servidor
    public ResponseEntity<List> mostrar(){ //ResponseEntity es un envoltorio
        List<TarjetaResponse> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping //Crear un nuevo recurso, la peticion sale de mi curso y sirve para llevar o cargar
    // nuevos datos al servidor
    //Para que el servidor sepa que le estas pidiendo datos a cerca de la peticion se coloca el RequestBody
    public ResponseEntity<TarjetaResponse> guardar(@RequestBody TarjetaRequest request){ //todo lo que devuelve el servidor es un response
        TarjetaResponse cuenta = service.crearTarjeta(request); //La peticion del cliente es un request
        return new ResponseEntity<TarjetaResponse>(cuenta, HttpStatusCode.valueOf(201));
    }

    @PutMapping //
    public ResponseEntity<TarjetaResponse> actualizar(@RequestBody TarjetaRequest request){//
        TarjetaResponse cuenta = service.actualizarTarjeta(request);
        return new ResponseEntity<TarjetaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    //http://localhost:8090/api/v1/cuentas/12
    @GetMapping("/{cuentaId}")
    public ResponseEntity<TarjetaResponse> buscar(@PathVariable int cuentaId){
        TarjetaResponse cuenta = service.buscarTarjeta(cuentaId);
        return new ResponseEntity<TarjetaResponse>(cuenta, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<String> eliminar(@PathVariable int cuentaId){
        String mensaje = service.eliminar(cuentaId);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
}
