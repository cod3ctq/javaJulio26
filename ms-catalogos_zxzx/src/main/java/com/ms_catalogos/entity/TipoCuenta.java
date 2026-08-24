package com.ms_catalogos.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TIPO_CUENTA")
public class TipoCuenta implements Serializable {
    @Id
    @Column(name = "TIPO_CUENTA_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoCuentaId;

    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2")
    private String descripcion;

    @Column(name = "SALDO_MIN", columnDefinition = "NUMBER")
    private double saldoMax;

    @Column(name = "SALDO_MAX", columnDefinition = "NUMBER")
    private double saldoMin;

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

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
    }

    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }
}
