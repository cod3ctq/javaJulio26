package com.ms_prestamos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PrestamosRequest {

    private int prestamoId;

    @NotNull(message = "El tipo de prestamo Id no puede ser nulo")
    @Positive(message = "No se permiten valores negativos")
    private int tipoPrestamoId;

    @NotNull(message = "El cliente Id no puede ser nulo")
    @Positive(message = "No se permiten valores negativos")
    private int clienteId;

    @NotNull(message = "El monto es requerido")
    @Positive(message = "No se permiten montos negativos")
    private int monto;

    public PrestamosRequest(int prestamoId, int tipoPrestamoId, int clienteId, int monto) {
        this.prestamoId = prestamoId;
        this.tipoPrestamoId = tipoPrestamoId;
        this.clienteId = clienteId;
        this.monto = monto;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public int getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "PrestamosRequest{" +
                "prestamoId=" + prestamoId +
                ", tipoPrestamoId=" + tipoPrestamoId +
                ", clienteId=" + clienteId +
                ", monto=" + monto +
                '}';
    }
}
