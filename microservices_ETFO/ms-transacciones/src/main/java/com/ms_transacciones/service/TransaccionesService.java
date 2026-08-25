package com.ms_transacciones.service;

import com.ms_transacciones.dto.TicketResponse;
import com.ms_transacciones.dto.TransaccionRequest;

public interface TransaccionesService {

    TicketResponse retirar(TransaccionRequest transaccionRequest);

    TicketResponse depositar(TransaccionRequest transaccionRequest);

}
