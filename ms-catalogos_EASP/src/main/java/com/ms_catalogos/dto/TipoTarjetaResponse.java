package com.ms_catalogos.dto;

public class TipoTarjetaResponse {

    private int tipoId;
    private String descripcion;

    public TipoTarjetaResponse(){}

    public TipoTarjetaResponse(int tipoId, String descripcion) {
        this.tipoId = tipoId;
        this.descripcion = descripcion;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
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
                "tipoId=" + tipoId +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
