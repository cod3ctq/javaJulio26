package com.ms_catalogos.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TIPO_PRESTAMO")
public class TipoPrestamo implements Serializable {

    @Id
    @Column(name = "TIPO_PRESTAMO_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoPrestamoId;

    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2(100)")
    private String descripcionTipoPrestamo;

    @Column(name = "INTERES", columnDefinition = "NUMBER")
    private int interes;

    @Column(name = "PLAZO", columnDefinition = "NUMBER")
    private int plazo;

    public int getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public String getDescripcionTipoPrestamo() {
        return descripcionTipoPrestamo;
    }

    public void setDescripcionTipoPrestamo(String descripcionTipoPrestamo) {
        this.descripcionTipoPrestamo = descripcionTipoPrestamo;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    @Override
    public String toString() {
        return "TipoPrestamo{" +
                "tipoPrestamoId=" + tipoPrestamoId +
                ", descripcionTipoPrestamo='" + descripcionTipoPrestamo + '\'' +
                ", interes=" + interes +
                ", plazo=" + plazo +
                '}';
    }
}
