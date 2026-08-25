package com.example.ms_transacciones.dto;

import java.time.LocalDate;

public record TarjetaRecord(int tarjetaId,
                            int cuentaId,
                            int tipoTarjetaId,
                            String numTarjeta,
                            LocalDate fechaVen,
                            String status) {
}
