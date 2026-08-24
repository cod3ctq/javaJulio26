package com.ms_catalogos.dto;

public class TipoTarjetaResponse {

    private String descripcion;

    public TipoTarjetaResponse() { }

    public TipoTarjetaResponse(String descripcion) {
        this.descripcion = descripcion;
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
                "descripcion='" + descripcion + '\'' +
                '}';
    }

}
