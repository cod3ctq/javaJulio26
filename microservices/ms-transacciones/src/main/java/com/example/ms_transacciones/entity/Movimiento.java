package com.example.ms_transacciones.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "MOVIMIENTOS")
public class Movimiento implements Serializable {

    @Id
    @Column(name = "MOV_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movId;
    @Column(name = "CUENTA_ID", columnDefinition = "NUMBER")
    private int cuentaId;
    @Column(name = "TIPO", columnDefinition = "VARCHAR2(100)")
    private String tipo;
    @Column(name = "FECHA", columnDefinition = "DATE")
    private LocalDate fecha;
    @Column(name = "MONTO", columnDefinition = "NUMBER(8,2)")
    private double monto;

    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
