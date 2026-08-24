package com.ms_cuentas.dto;

//Un record es un DOT inmutable
public record TipoCuentaRecord(int tipoCuentaId,
                               String descripcion,
                               double saldoMax,
                               double saldoMin) {
}
