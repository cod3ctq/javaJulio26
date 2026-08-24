package com.ms_catalogos.dto;

import jakarta.persistence.Column;

public class TipoTarjetaRequest {

    private int tipoTId;
    private String descripcion;

    public TipoTarjetaRequest() { }

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
}
