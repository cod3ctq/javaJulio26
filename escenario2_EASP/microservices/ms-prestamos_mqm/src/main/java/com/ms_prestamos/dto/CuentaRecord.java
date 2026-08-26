package com.ms_prestamos.dto;

import java.time.LocalDate;

public record CuentaRecord (int cuentaId,
                           int clienteId,
                           int tipoCuentaId,
                           String numCuenta,
                           String clabe,
                           double saldo,
                           LocalDate fecha,
                           char status){
}
