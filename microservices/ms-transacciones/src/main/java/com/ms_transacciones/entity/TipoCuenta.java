package com.ms_transacciones.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "TIPO_CUENTA")
public class TipoCuenta implements Serializable {

    @Id
    @Column(name = "TIPO_CUENTA_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoCuentaId;

    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2(100)")
    private String descripcionTipoCuenta;

    @Column(name = "SALDO_MIN", columnDefinition = "NUMBER")
    private double saldoMin;

    @Column(name = "SALDO_MAX", columnDefinition = "NUMBER")
    private double saldoMax;

    public int getTipoCuentaId() {
        return tipoCuentaId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
    }

    public String getDescripcionTipoCuenta() {
        return descripcionTipoCuenta;
    }

    public void setDescripcionTipoCuenta(String descripcionTipoCuenta) {
        this.descripcionTipoCuenta = descripcionTipoCuenta;
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
        return "TipoCuenta{" +
                "tipoCuentaId=" + tipoCuentaId +
                ", descripcionTipoCuenta='" + descripcionTipoCuenta + '\'' +
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                '}';
    }
}

