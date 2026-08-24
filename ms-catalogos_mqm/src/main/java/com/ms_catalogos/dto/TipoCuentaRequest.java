package com.ms_catalogos.dto;

import jakarta.persistence.Column;

public class TipoCuentaRequest {

    private int tipoCuentaId;
    private String descripcionTipoCuenta;
    private double saldoMin;
    private double saldoMax;

    public TipoCuentaRequest(int tipoCuentaId, String descripcionTipoCuenta, double saldoMin, double saldoMax) {
        this.tipoCuentaId = tipoCuentaId;
        this.descripcionTipoCuenta = descripcionTipoCuenta;
        this.saldoMin = saldoMin;
        this.saldoMax = saldoMax;
    }

    public int getTipoCuentaId() {
        return tipoCuentaId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
    }

    public String getDescripcionTipoCuenta() {
        return descripcionTipoCuenta;
    }

    public void setDescripcionTipoCuenta(String descripcionTipoCuenta) {
        this.descripcionTipoCuenta = descripcionTipoCuenta;
    }

    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
    }

    @Override
    public String toString() {
        return "TipoCuentaRequest{" +
                "tipoCuentaId=" + tipoCuentaId +
                ", descripcionTipoCuenta='" + descripcionTipoCuenta + '\'' +
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                '}';
    }
}
