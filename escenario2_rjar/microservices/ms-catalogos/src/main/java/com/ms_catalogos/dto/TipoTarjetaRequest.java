package com.ms_catalogos.dto;

public class TipoTarjetaRequest {
    private int tipoId;
    private String descripcion;

    public TipoTarjetaRequest(){}

    public TipoTarjetaRequest(int tipoId, String descripcion) {
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
        return "TipoTarjetaRequest{" +
                "tipoId=" + tipoId +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
