package com.ms_catalogos.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "MEDIO_PAOG")
public class MedioPago implements Serializable {

    @Id
    @Column(name = "MEDIO_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medioId;

    @Column(name = "descripcion", columnDefinition = "VARCHAR2(100)")
    private String descripcionMedioPago;

    public int getMedioId() {
        return medioId;
    }

    public void setMedioId(int medioId) {
        this.medioId = medioId;
    }

    public String getDescripcionMedioPago() {
        return descripcionMedioPago;
    }

    public void setDescripcionMedioPago(String descripcionMedioPago) {
        this.descripcionMedioPago = descripcionMedioPago;
    }

    @Override
    public String toString() {
        return "MedioPago{" +
                "medioId=" + medioId +
                ", descripcionMedioPago='" + descripcionMedioPago + '\'' +
                '}';
    }




}
