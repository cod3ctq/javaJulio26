package com.ms_catalogos.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="MEDIOS_PAGO")
public class MedioPago implements Serializable {

    @Id
    @Column (name = "MEDIO_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medioId;

    @Column(name = "DESCRIPCION",columnDefinition = "VARVHAR(100)")
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
}
