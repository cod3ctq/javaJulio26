package com.ms_tarjetas.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TIPO_TARJETA")
public class TipoTarjeta implements Serializable {

    @Id
    @Column(name = "TIPO_T_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoTarjetaId;

    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2")
    private String descripcion;


    public int getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(int tipoTarjetaId) {
        this.tipoTarjetaId = tipoTarjetaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
