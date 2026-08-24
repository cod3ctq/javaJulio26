package com.ms_catalogos.dto;

public class MedioPagoResponse {

    private int medioId;
    private String descripcionMedioPago;

    public MedioPagoResponse (){}

    public MedioPagoResponse(int medioId, String descripcionMedioPago) {
        this.medioId = medioId;
        this.descripcionMedioPago = descripcionMedioPago;
    }

    public int getMedioId() {
        return medioId;
    }

    public void setMedioId(int medioId) {
        this.medioId = medioId;
    }

    public String getDescripcionMedioPago() {
        return descripcionMedioPago;
    }

    public void setDescripcionMedioPago(String descripcionMedioPago) {
        this.descripcionMedioPago = descripcionMedioPago;
    }

    @Override
    public String toString() {
        return "MedioPagoResponse{" +
                "medioId=" + medioId +
                ", descripcionMedioPago='" + descripcionMedioPago + '\'' +
                '}';
    }
}