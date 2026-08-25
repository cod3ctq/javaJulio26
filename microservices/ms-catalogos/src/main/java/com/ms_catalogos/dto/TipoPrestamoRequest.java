package com.ms_catalogos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TipoPrestamoRequest {

    private int tipoPrestamoId;

    @NotNull(message = "La descripción no puede ser nula")
    private String descripcion;

    @NotNull(message = "El interés no puede quedar nulo")
    @Positive(message = "El interés no puede ser negativo")
    private int interes;

    @NotNull(message = "El plazo no puede quedar nulo")
    @Positive(message = "El plazo no puede ser negativo")
    private int plazo;

    public TipoPrestamoRequest(){}

    public TipoPrestamoRequest(int tipoPrestamoId, String descripcion, int interes, int plazo) {
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

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
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
