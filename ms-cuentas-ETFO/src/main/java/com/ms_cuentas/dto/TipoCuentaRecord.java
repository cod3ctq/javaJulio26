package com.ms_cuentas.dto;

public record TipoCuentaRecord
        (
        int tipoCuentaId,
        String descripcion,
        double saldoMax,
        double saldoMin
        )
{
}
