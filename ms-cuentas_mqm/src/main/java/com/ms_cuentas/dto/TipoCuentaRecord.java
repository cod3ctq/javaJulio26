package com.ms_cuentas.dto;

//un record es un DTO inmutable
//que generera automaticamente en tiempo de ejecucion el contructor
// getter y toString, al ser inmutable no generara setters
public record TipoCuentaRecord(int tipoCuentaId,
                               String descripcion,
                               double saldoMax,
                               double saldoMin) {
}
