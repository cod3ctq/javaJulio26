package com.ms_prestamos.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table (name = "PRESTAMOS")
public class Prestamos implements Serializable {

    @Id
    @Column(name = "PRESTAMO_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prestamoId;

    @Column(name = "TIPO_ID", columnDefinition = "NUMBER")
    private int tipoPrestamoId;

    @Column(name = "CLIENTE_ID", columnDefinition = "NUMBER")
    private int clienteId;

    @Column(name = "FECHA", columnDefinition = "DATE")
    private LocalDate fecha;

    @Column(name = "MONTO", columnDefinition = "NUMBER")
    private int monto;

    @NotNull(message = "La fecha no puede ser nulo")
    @Column(name = "FECHA_FIN", columnDefinition = "DATE")
    private LocalDate fechaFin;

    @Column(name = "RESTANTE", columnDefinition = "NUMBER")
    private int restante;

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public int getRestante() {
        return restante;
    }

    public void setRestante(int restante) {
        this.restante = restante;
    }

    @Override
    public String toString() {
        return "Prestamos{" +
                "prestamoId=" + prestamoId +
                ", tipoPrestamoId=" + tipoPrestamoId +
                ", clienteId=" + clienteId +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", fechaFin=" + fechaFin +
                ", restante=" + restante +
                '}';
    }
}
