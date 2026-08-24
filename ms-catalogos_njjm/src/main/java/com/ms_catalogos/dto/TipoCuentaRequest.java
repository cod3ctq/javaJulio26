package com.ms_catalogos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TipoCuentaRequest {

    private int tipoCuentaId;
    @NotNull(message = "La descripción no puede ser nula")
    private String descripcion;
    @NotNull(message = "El saldo máximo no puede quedar nulo")
    @Positive(message = "El saldo máximo no puede ser negativo")
    private double saldoMax;
    @NotNull(message = "El saldo mínimo no puede quedar nulo")
    @Positive(message = "El saldo mínimo no puede ser negativo")
    private double saldoMin;

    public TipoCuentaRequest() {}

    public TipoCuentaRequest(int tipoCuentaId, String descripcion, double saldoMax, double saldoMin) {
        this.tipoCuentaId = tipoCuentaId;
        this.descripcion = descripcion;
        this.saldoMax = saldoMax;
        this.saldoMin = saldoMin;
    }

    public int getTipoCuentaId() {
        return tipoCuentaId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
    }

    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }

    @Override
    public String toString() {
        return "TipoCuentaRequest{" +
                "tipoCuentaId=" + tipoCuentaId +
                ", descripcion='" + descripcion + '\'' +
                ", saldoMax=" + saldoMax +
                ", saldoMin=" + saldoMin +
                '}';
    }

}
