package com.example.ms_transacciones.controller;

import com.example.ms_transacciones.dto.TicketResponse;
import com.example.ms_transacciones.dto.TransaccionRequest;
import com.example.ms_transacciones.services.impl.TransaccionImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transacciones")
public class TransaccionController {

    @Autowired
    TransaccionImpl service;

    @PostMapping("/retirar")
    public ResponseEntity<TicketResponse> retirar(@Valid @RequestBody TransaccionRequest request){
        TicketResponse response = service.retirar(request);
        return new ResponseEntity<TicketResponse>(response, HttpStatusCode.valueOf(201));
    }

    @PostMapping("/depositar")
    public ResponseEntity<TicketResponse> depositar(@Valid @RequestBody TransaccionRequest request){
        TicketResponse response = service.depositar(request);
        return new ResponseEntity<TicketResponse>(response,HttpStatusCode.valueOf(201));
    }
}
