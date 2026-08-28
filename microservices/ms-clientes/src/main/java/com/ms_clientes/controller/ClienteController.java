package com.ms_clientes.controller;

import com.ms_clientes.dto.request.ClienteRequest;
import com.ms_clientes.dto.response.ClienteRecord;
import com.ms_clientes.entity.Clientes;
import com.ms_clientes.logic.ClienteLogic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    @Autowired
    ClienteLogic service;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<ClienteRecord> guardar(@Valid @RequestBody ClienteRequest request){
        ClienteRecord c = service.guardar(request);
        return new ResponseEntity<ClienteRecord>(c, HttpStatusCode.valueOf(200));
    }

    @PatchMapping
    public ResponseEntity<ClienteRecord> actualizar(@Valid @RequestBody ClienteRequest request){
        ClienteRecord c = service.actualizar(request);
        return new ResponseEntity<ClienteRecord>(c, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{nombre}") //http://localhost:8092/api/v1/clientes/buscar
    public ResponseEntity<ClienteRecord> buscar(@PathVariable String nombre){
        ClienteRecord c = service.buscar(nombre);
        return new ResponseEntity<ClienteRecord>(c, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<String> eliminar(@PathVariable int clienteId){
        String mensaje = service.eliminar(clienteId);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

}
