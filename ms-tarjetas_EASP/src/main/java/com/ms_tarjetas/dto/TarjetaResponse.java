package com.ms_tarjetas.dto;

import java.time.LocalDate;

public class TarjetaResponse {

    private int tarjetaId;
    private int tipoTarjetaId;
    private String numTarjeta;
    private LocalDate fechaVen;

    public TarjetaResponse (){}

    public TarjetaResponse(int tarjetaId, int tipoTarjetaId, String numTarjeta, LocalDate fechaVen) {
        this.tarjetaId = tarjetaId;
        this.tipoTarjetaId = tipoTarjetaId;
        this.numTarjeta = numTarjeta;
        this.fechaVen = fechaVen;
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

    @Override
    public String toString() {
        return "TarjetaResponse{" +
                "tarjetaId=" + tarjetaId +
                ", tipoTarjetaId=" + tipoTarjetaId +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", fechaVen=" + fechaVen +
                '}';
    }
}
