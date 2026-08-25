package com.ms_cuentas.dto;

import java.time.LocalDate;

public record TarjetaRecord(int tarjetaId,
                            int cuentaId,
                            int tipoTarjetaId,
                            String numTarjeta,
                            String nip,
                            LocalDate fechaVen,
                            String status) {
}
