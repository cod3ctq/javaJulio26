package com.ms_prestamos.dto;

import java.time.LocalDate;

public class PrestamosResponse {

    private int prestamoId;
    private int clienteId;
    private LocalDate fecha;
    private int tipoPrestamoId;
    private int monto;
    private LocalDate fechaFin;

    public PrestamosResponse (){}

    public PrestamosResponse(int prestamoId, int clienteId, LocalDate fecha, int tipoPrestamoId, int monto, LocalDate fechaFin) {
        this.prestamoId = prestamoId;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.tipoPrestamoId = tipoPrestamoId;
        this.monto = monto;
        this.fechaFin = fechaFin;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "PrestamosResponse{" +
                "prestamoId=" + prestamoId +
                ", clienteId=" + clienteId +
                ", fecha=" + fecha +
                ", tipoPrestamoId=" + tipoPrestamoId +
                ", monto=" + monto +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
