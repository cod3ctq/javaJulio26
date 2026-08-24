package com.ms_catalogos.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name="MEDIOS_PAGO")
public class MedioPago implements Serializable {

    @Id
    @Column(name = "MEDIO_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medioId;

    @Column (name = "DESCRIPCION", columnDefinition = "VARCHAR2(100)")
    private String descripcion;

    public int getMedioId() {
        return medioId;
    }

    public void setMedioId(int medioId) {
        this.medioId = medioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
