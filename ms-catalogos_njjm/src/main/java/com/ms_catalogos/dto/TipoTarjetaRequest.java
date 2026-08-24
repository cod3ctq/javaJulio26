package com.ms_catalogos.dto;

import jakarta.validation.constraints.NotNull;

public class TipoTarjetaRequest {

    private int tipoTId;

    @NotNull(message = "La descripción no puede ser nula")
    private String descripcion;

    public TipoTarjetaRequest(){}

    public TipoTarjetaRequest(int tipoTId, String descripcion) {
        this.tipoTId = tipoTId;
        this.descripcion = descripcion;
    }

    public int getTipoTId() {
        return tipoTId;
    }

    public void setTipoTId(int tipoTId) {
        this.tipoTId = tipoTId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoTarjetaRequest{" +
                "tipoTId=" + tipoTId +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
