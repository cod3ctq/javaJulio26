package com.ms_tarjetas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TarjetaRequest {

    private int tarjetaId;
    @NotNull (message = "La cuenta id no puede quedar nulo")
    @Positive(message = "No se permiten valores negativos")
    private int cuentaId;
    @NotNull (message = "El tipo de tarjeta no puede quedar nulo")
    @Positive (message = "No se permiten valores negativos")
    private int tipoTarjetaId;

    public TarjetaRequest (){}

    public TarjetaRequest(int tarjetaId, int cuentaId, int tipoTarjetaId) {
        this.tarjetaId = tarjetaId;
        this.cuentaId = cuentaId;
        this.tipoTarjetaId = tipoTarjetaId;
    }

    public int getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(int tipoTarjetaId) {
        this.tipoTarjetaId = tipoTarjetaId;
    }

    @Override
    public String toString() {
        return "TarjetaRequest{" +
                "tarjetaId=" + tarjetaId +
                ", cuentaId=" + cuentaId +
                ", tipoTarjetaId=" + tipoTarjetaId +
                '}';
    }
}
