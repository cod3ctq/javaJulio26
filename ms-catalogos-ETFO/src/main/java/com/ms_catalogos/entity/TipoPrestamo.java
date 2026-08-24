package com.ms_catalogos.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TIPO_PRESTAMO")
public class TipoPrestamo implements Serializable {

    @Id
    @Column(name = "TIPO_PRESTAMO_ID", columnDefinition = "NUMBER")
    @GeneratedValue()
    private int tipoPrestamoId;

    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2")
    private String descripcion;

    @Column(name = "INTERES", columnDefinition = "NUMBER")
    private double interes;

    @Column(name = "PLAZO", columnDefinition = "NUMBER")
    private int plazo;

    public int getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

}
