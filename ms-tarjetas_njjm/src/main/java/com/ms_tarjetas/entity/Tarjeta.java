package com.ms_tarjetas.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TARJETAS")
public class Tarjeta implements Serializable {
    @Id
    @Column(name = "TARJETA_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tarjetaId;
    @Column(name = "CUENTA_ID", columnDefinition = "NUMBER")
    private int cuentaId;
    @Column(name = "TIPO_TARJETA_ID", columnDefinition = "NUMBER")
    private int tipoTarjetaId;
    @Column(name = "NUM_TARJETA", columnDefinition = "CHAR(16)")
    private String numTarjeta;
    @Column(name = "NIP", columnDefinition = "CHAR(4)")
    private String nip;
    @Column(name = "FECHA_VEN", columnDefinition = "DATE")
    private LocalDate fechaVen;
    @Column(name = "STATUS", columnDefinition = "VARCHAR2(15)")
    private String status;

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public int getTipoTarjetaId() {
        return tipoTarjetaId;
    }

    public void setTipoTarjetaId(int tipoTarjetaId) {
        this.tipoTarjetaId = tipoTarjetaId;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
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


