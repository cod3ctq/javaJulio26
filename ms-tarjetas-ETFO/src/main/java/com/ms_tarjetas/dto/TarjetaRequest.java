package com.ms_tarjetas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TarjetaRequest {

    private int tarjetaId;

    @NotNull(message = "El Id de cuenta no puede quedar nulo")
    @Positive(message = "No se permiten valores negativos")
    private Integer cuentaId;

    @NotNull(message = "No se permiten valores nulos")
    @Positive(message = "No se permiten valores negativos")
    private Integer tipoTarjetaId;

    public TarjetaRequest() { }

    public TarjetaRequest(int tarjetaId, Integer cuentaId, Integer tipoTarjetaId) {
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

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Integer getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(Integer tipoTarjetaId) {
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
