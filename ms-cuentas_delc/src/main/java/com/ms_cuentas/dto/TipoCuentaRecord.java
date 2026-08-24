package com.ms_cuentas.dto;

//Un record es un DTO INMUTABLE
public record TipoCuentaRecord(int tipoCuentaId, String descripcion,
                               double saldoMax, double saldoMin) {

}
