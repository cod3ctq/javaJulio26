package com.ms_tarjetas.dto;

import java.time.LocalDate;

public class TarjetaResponse {

    private int tarjetaId;
    private int tipoTarjetaId;
    private String numTarjeta;
    private LocalDate fechaVen;
    private String status;

    public TarjetaResponse(){}

    public TarjetaResponse(int tarjetaId, int tipoTarjetaId, String numTarjeta, LocalDate fechaVen, String status) {
        this.tarjetaId = tarjetaId;
        this.tipoTarjetaId = tipoTarjetaId;
        this.numTarjeta = numTarjeta;
        this.fechaVen = fechaVen;
        this.status = status;
    }

    public int getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public int getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(int tipoTarjetaId) {
        this.tipoTarjetaId = tipoTarjetaId;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public LocalDate getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(LocalDate fechaVen) {
        this.fechaVen = fechaVen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TarjetaResponse{" +
                "tarjetaId=" + tarjetaId +
                ", tipoTarjetaId=" + tipoTarjetaId +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", fechaVen=" + fechaVen +
                ", status='" + status + '\'' +
                '}';
    }
}
