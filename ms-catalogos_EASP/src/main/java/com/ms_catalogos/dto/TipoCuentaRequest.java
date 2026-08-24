package com.ms_catalogos.dto;

public class TipoCuentaRequest {

    private int tipoCuentaId;
    private String descripcion;
    private Double saldoMin;
    private Double saldoMax;

    public TipoCuentaRequest(){}

    public TipoCuentaRequest(int tipoCuentaId, String descripcion, Double saldoMin, Double saldoMax) {
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

    public Double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(Double saldoMin) {
        this.saldoMin = saldoMin;
    }

    public Double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(Double saldoMax) {
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
