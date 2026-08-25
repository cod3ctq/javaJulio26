package com.ms_catalogos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MedioPagoRequest {

    @NotNull(message = "El cliente id no puede quedar nulo")
    @Positive(message = "No se permiten valores negativos")
    private int medioId;

    @NotNull(message = "La descripcion no puede ser nulo")
    private String descripcion;

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

    public String getDescripcionMedioPago() {
        return descripcion;
    }

    public void setDescripcionMedioPago(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MedioPagoRequest{" +
                "medioId=" + medioId +
                ", descripcionMedioPago='" + descripcion + '\'' +
                '}';
    }

}
