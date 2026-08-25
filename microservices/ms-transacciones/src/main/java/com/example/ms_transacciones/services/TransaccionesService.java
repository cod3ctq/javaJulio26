package com.example.ms_transacciones.services;

import com.example.ms_transacciones.dto.TicketResponse;
import com.example.ms_transacciones.dto.TransaccionRequest;

public interface TransaccionesService {
    TicketResponse retirar(TransaccionRequest request);
    TicketResponse depositar(TransaccionRequest request);
}
