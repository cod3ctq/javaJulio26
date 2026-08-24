package com.ms_tarjetas.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="TARJETAS")

public class Tarjetas implements Serializable {

    public static Object set;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int tarjetaId;
    @Column(name = "TARJETA_ID", columnDefinition = "NUMBER")

    private int cuentaId;
    @Column(name = "CUENTA_ID", columnDefinition = "NUMBER")

    private int tipoTarjetaId;
    @Column(name = "TIPO_TARJETA_ID", columnDefinition = "NUMBER")

    private int numTarjeta;
    @Column(name = "NUM_TARJETA", columnDefinition = "NUMBER")

    private int nip;
    @Column(name = "NIP", columnDefinition = "NUMBER")

    private LocalDate fechaVen;
    @Column(name = "FECHA_VEN", columnDefinition = "DATE")

    private String status;

    public static void setNumTarjeta() {
    }

    @Column(name = "STATUS", columnDefinition = "NVARCHAR2(11)")



    public int getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(int tipoTarjetaId) {
        this.tipoTarjetaId = tipoTarjetaId;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public LocalDate getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(LocalDate fechaVen) {
        this.fechaVen = fechaVen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
