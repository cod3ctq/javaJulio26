package com.ms_prestamos.dto;

import java.time.LocalDate;

public class PrestamoResponse {

    private int clienteId;
    private int tipoPrestamoId;
    private LocalDate fecha;
    private double monto;
    private int prestamoId;

    public PrestamoResponse (){}

    public PrestamoResponse(int clienteId, int tipoPrestamoId, LocalDate fecha, double monto, int prestamoId) {
        this.clienteId = clienteId;
        this.tipoPrestamoId = tipoPrestamoId;
        this.fecha = fecha;
        this.monto = monto;
        this.prestamoId = prestamoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    @Override
    public String toString() {
        return "PrestamoResponse{" +
                "clienteId=" + clienteId +
                ", tipoPrestamoId=" + tipoPrestamoId +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", prestamoId=" + prestamoId +
                '}';
    }
}
