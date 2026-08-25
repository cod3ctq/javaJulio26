package com.ms_catalogos.dto;

import jakarta.persistence.Column;

public class TipoPrestamoRequest {

    private int tipoPrestamoId;
    private String descripcion;
    private double interes;
    private int plazo;

    public TipoPrestamoRequest() { }

    public TipoPrestamoRequest(int tipoPrestamoId, String descripcion, double interes, int plazo) {
        this.tipoPrestamoId = tipoPrestamoId;
        this.descripcion = descripcion;
        this.interes = interes;
        this.plazo = plazo;
    }

    public int getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    @Override
    public String toString() {
        return "TipoPrestamoRequest{" +
                "tipoPrestamoId=" + tipoPrestamoId +
                ", descripcion='" + descripcion + '\'' +
                ", interes=" + interes +
                ", plazo=" + plazo +
                '}';
    }
}
