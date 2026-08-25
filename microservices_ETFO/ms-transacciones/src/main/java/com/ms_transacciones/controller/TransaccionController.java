package com.ms_transacciones.controller;

import com.ms_transacciones.dto.TicketResponse;
import com.ms_transacciones.dto.TransaccionRequest;
import com.ms_transacciones.service.TransaccionesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/transacciones")
public class TransaccionController {

    @Autowired
    TransaccionesService transaccionesService;

    @PostMapping("/retirar")
    public ResponseEntity<TicketResponse> retirar(@Valid @RequestBody TransaccionRequest transaccionRequest) {
        TicketResponse ticketResponse = transaccionesService.retirar(transaccionRequest);
        return new ResponseEntity<TicketResponse>(ticketResponse, HttpStatusCode.valueOf(201));
    }

    @PostMapping("/depositar")
    public ResponseEntity<TicketResponse> depsitar(@Valid @RequestBody TransaccionRequest transaccionRequest) {
        TicketResponse ticketResponse = transaccionesService.depositar(transaccionRequest);
        return new ResponseEntity<TicketResponse>(ticketResponse, HttpStatusCode.valueOf(201));
    }

}
