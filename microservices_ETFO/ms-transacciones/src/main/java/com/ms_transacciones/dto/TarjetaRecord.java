package com.ms_transacciones.dto;

import java.time.LocalDate;

public record TarjetaRecord
        (
                int cuentaId,
                int tipoTarjetaId,
                String numTarjeta,
                LocalDate fechaVen
        ) {
}
