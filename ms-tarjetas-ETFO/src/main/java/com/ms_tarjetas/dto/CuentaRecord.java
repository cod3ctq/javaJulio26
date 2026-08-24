package com.ms_tarjetas.dto;

import java.time.LocalDate;

public record CuentaRecord
        (
                int cuentaId,
                int tipoCuentaId,
                String numCuenta,
                String clabe,
                double saldo,
                LocalDate fecha
        )
{

}
