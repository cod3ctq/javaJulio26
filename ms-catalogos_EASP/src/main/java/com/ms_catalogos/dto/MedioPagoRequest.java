package com.ms_catalogos.dto;

import jakarta.validation.constraints.NotNull;

public class MedioPagoRequest {

    private int medioId;

    @NotNull(message = "La descripcion no puede ser nula")
    private String descripcion;

    public MedioPagoRequest(){}

    public MedioPagoRequest(int medioId, String descripcion) {
        this.medioId = medioId;
        this.descripcion = descripcion;
    }

    public int getMedioId() {
        return medioId;
    }

    public void setMedioId(int medioId) {
        this.medioId = medioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MedioPagoRequest{" +
                "medioId=" + medioId +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
