package com.ms_prestamos.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="PRESTAMOS")
public class Prestamo implements Serializable{

    @Id
    @Column(name="PRESTAMO_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prestamoId;

    @Column(name="TIPO_ID", columnDefinition = "NUMBER")
    private int tipoId;

    @Column(name="CLIENTE_ID", columnDefinition = "NUMBER")
    private int clienteId;

    @Column(name="MONTO", columnDefinition = "NUMBER(12,2)")
    private double monto;

    @Column(name="RESTANTE", columnDefinition = "NUMBER(12,2)")
    private double restante;

    @Column(name="FECHA", columnDefinition = "DATE")
    private LocalDate fecha;

    @Column(name="FECHA_FIN", columnDefinition = "DATE")
    private LocalDate fechaFin;

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

    public double getRestante() {
        return restante;
    }

    public void setRestante(double restante) {
        this.restante = restante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
