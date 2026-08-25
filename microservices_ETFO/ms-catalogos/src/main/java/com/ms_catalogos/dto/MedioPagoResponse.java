package com.ms_catalogos.dto;

public class MedioPagoResponse {

    private Integer medioId;
    private String descripcion;

    public MedioPagoResponse() { }

    public MedioPagoResponse(Integer medioId, String descripcion) {
        this.medioId = medioId;
        this.descripcion = descripcion;
    }

    public Integer getMedioId() {
        return medioId;
    }

    public void setMedioId(Integer medioId) {
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
        return "MedioPagoResponse{" +
                "medioId=" + medioId +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
