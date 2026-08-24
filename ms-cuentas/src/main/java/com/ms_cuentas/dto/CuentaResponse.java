package com.ms_cuentas.dto;

//Response : Mapea los objetos que van del servidor hacia el cliente (respuestas).

import jakarta.persistence.Column;

import java.time.LocalDate;

public class CuentaResponse {

    private int cuentaID;
    private int tipoCuentaId;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private LocalDate fecha;


    public CuentaResponse(){}



    public CuentaResponse(int cuentaID, int tipoCuentaId, String numCuenta, String clabe, double saldo, LocalDate fecha) {
        this.cuentaID = cuentaID;
        this.tipoCuentaId = tipoCuentaId;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.fecha = fecha;
    }



    public int getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(int cuentaID) {
        this.cuentaID = cuentaID;
    }

    public int getTipoCuentaId() {
        return tipoCuentaId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }



    @Override
    public String toString() {
        return "CuentaResponse{" +
                "cuentaID=" + cuentaID +
                ", tipoCuentaId=" + tipoCuentaId +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", fecha=" + fecha +
                '}';
    }
}
