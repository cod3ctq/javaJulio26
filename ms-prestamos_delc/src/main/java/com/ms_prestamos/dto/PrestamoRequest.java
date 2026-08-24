package com.ms_prestamos.dto;

public class PrestamoRequest {

    private int prestamoId;
    private int tipoId;
    private int clienteId;
    private double monto;

    public PrestamoRequest(){}

    public PrestamoRequest(int prestamoId, int tipoId, int clienteId, double monto) {
        this.prestamoId = prestamoId;
        this.tipoId = tipoId;
        this.clienteId = clienteId;
        this.monto = monto;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "PrestamoRequest{" +
                "prestamoId=" + prestamoId +
                ", tipoId=" + tipoId +
                ", clienteId=" + clienteId +
                ", monto=" + monto +
                '}';
    }
}
