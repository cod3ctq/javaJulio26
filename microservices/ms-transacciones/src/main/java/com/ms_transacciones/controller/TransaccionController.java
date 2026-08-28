package com.ms_transacciones.controller;

import com.ms_transacciones.dto.TicketResponse;
import com.ms_transacciones.dto.TransaccionRequest;
import com.ms_transacciones.service.impl.TransaccionImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/transacciones")
public class TransaccionController {

    @Autowired
    TransaccionImpl service;

    @PostMapping("/retirar")
    public ResponseEntity<TicketResponse>retirar(@Valid @RequestBody TransaccionRequest request){
        TicketResponse response = service.retirar(request);
        return new ResponseEntity<TicketResponse>(response, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/depositar")
    public ResponseEntity<TicketResponse>depositar(@Valid @RequestBody TransaccionRequest request){
        TicketResponse response = service.depositar(request);
        return new ResponseEntity<TicketResponse>(response, HttpStatusCode.valueOf(200));
    }

}
