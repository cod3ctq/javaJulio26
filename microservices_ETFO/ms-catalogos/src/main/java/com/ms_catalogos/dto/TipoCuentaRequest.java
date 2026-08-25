package com.ms_catalogos.dto;

public class TipoCuentaRequest {

    private int tipoCuentaId;
    private String descripcion;
    private double saldoMin;
    private double saldoMax;

    public TipoCuentaRequest() { }

    public TipoCuentaRequest(int tipoCuentaId, String descripcion, double saldoMax, double saldoMin) {
        this.tipoCuentaId = tipoCuentaId;
        this.descripcion = descripcion;
        this.saldoMin = saldoMin;
        this.saldoMax = saldoMax;
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
                ", descripcion='" + descripcion + '\'' +
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                '}';
    }
}
