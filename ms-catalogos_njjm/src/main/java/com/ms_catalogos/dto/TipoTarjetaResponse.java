package com.ms_catalogos.dto;

import jakarta.persistence.Column;

public class TipoTarjetaResponse {

    private int tipoTId;
    private String descripcion;

    public TipoTarjetaResponse(){}

    public TipoTarjetaResponse(int tipoTId, String descripcion) {
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
        return "TipoTarjetaResponse{" +
                "tipoTId=" + tipoTId +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
