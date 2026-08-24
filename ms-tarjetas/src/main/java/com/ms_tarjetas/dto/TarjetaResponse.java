package com.ms_tarjetas.dto;

import java.time.LocalDate;

public class TarjetaResponse {

    public int getTarjetaId;
    public int getCuentaId;
    public String getStatus;
    private int tipoTarjetaId;
    private int numTarjeta;
    private LocalDate fechaVen;


    public TarjetaResponse(int getTarjetaId, int getCuentaId, String getStatus, int tipoTarjetaId, int numTarjeta, LocalDate fechaVen) {
        this.getTarjetaId = getTarjetaId;
        this.getCuentaId = getCuentaId;
        this.getStatus = getStatus;
        this.tipoTarjetaId = tipoTarjetaId;
        this.numTarjeta = numTarjeta;
        this.fechaVen = fechaVen;
    }

    public int getGetTarjetaId() {
        return getTarjetaId;
    }

    public void setGetTarjetaId(int getTarjetaId) {
        this.getTarjetaId = getTarjetaId;
    }

    public int getGetCuentaId() {
        return getCuentaId;
    }

    public void setGetCuentaId(int getCuentaId) {
        this.getCuentaId = getCuentaId;
    }

    public String getGetStatus() {
        return getStatus;
    }

    public void setGetStatus(String getStatus) {
        this.getStatus = getStatus;
    }

    public int getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(int tipoTarjetaId) {
        this.tipoTarjetaId = tipoTarjetaId;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
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
                "getTarjetaId=" + getTarjetaId +
                ", getCuentaId=" + getCuentaId +
                ", getStatus='" + getStatus + '\'' +
                ", tipoTarjetaId=" + tipoTarjetaId +
                ", numTarjeta=" + numTarjeta +
                ", fechaVen=" + fechaVen +
                '}';
    }
}
