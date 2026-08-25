package com.ms_transacciones.dto;

public record TipoCuentaRecord
        (
                int tipoCuentaId,
                String descripcion,
                double saldoMin,
                double saldoMax
        )
{

}
