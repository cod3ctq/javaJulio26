package com.ms_tarjetas.dto;

import java.time.LocalDate;

//DTO : Transmision de datos
//Datos que vienen desde el cliente
//se llama Request (Peticion) por que mapea los datos que llegaran en las peticines hacie este servicio.

public class TarjetaRequest {

    public int getTarjetaId;
    public int getCuentaId;
    public String getStatus;
    private int tipoTarjetaId;
    private int numTarjeta;
    private LocalDate fechaVen;


    public TarjetaRequest(){}


    public TarjetaRequest(int tipoTarjetaId, int numTarjeta, LocalDate fechaVen) {
        this.tipoTarjetaId = tipoTarjetaId;
        this.numTarjeta = numTarjeta;
        this.fechaVen = fechaVen;
    }

    public int getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(int tipoTarjetaId) {
        this.tipoTarjetaId = tipoTarjetaId;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public LocalDate getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(LocalDate fechaVen) {
        this.fechaVen = fechaVen;
    }


    @Override
    public String toString() {
        return "TarjetasRequest{" +
                "tipoTarjetaId=" + tipoTarjetaId +
                ", numTarjeta=" + numTarjeta +
                ", fechaVen=" + fechaVen +
                '}';
    }
}
