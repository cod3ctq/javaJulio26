package com.example.ms_transacciones.dto;

import java.time.LocalDate;

public record TicketResponse(LocalDate fecha,
                             String operacion,
                             double monto,
                             String numCuenta) {
}
