package com.ms_catalogos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "TIPO_PRESTAMO")
public class TipoPrestamo implements Serializable {

    @Id
    @Column(name = "TIPO_PRESTAMO_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoPrestamoId;

    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2(100)")
    private String descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

}
