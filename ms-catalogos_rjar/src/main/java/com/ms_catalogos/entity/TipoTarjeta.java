package com.ms_catalogos.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TIPO_TARJETA")
public class TipoTarjeta implements Serializable {

    @Id
    @Column(name = "TIPO_T_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoTarjetaId;

    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2(100)")
    private String descripcionTipoTarjeta;

    public int getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(int tipoTarjetaId) {
        this.tipoTarjetaId = tipoTarjetaId;
    }

    public String getDescripcionTipoTarjeta() {
        return descripcionTipoTarjeta;
    }

    public void setDescripcionTipoTarjeta(String descripcionTipoTarjeta) {
        this.descripcionTipoTarjeta = descripcionTipoTarjeta;
    }

    @Override
    public String toString() {
        return "TipoTarjeta{" +
                "tipoTarjetaId=" + tipoTarjetaId +
                ", descripcionTipoTarjeta='" + descripcionTipoTarjeta + '\'' +
                '}';
    }
}

