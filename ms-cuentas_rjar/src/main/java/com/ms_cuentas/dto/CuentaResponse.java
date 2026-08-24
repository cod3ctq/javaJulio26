package com.ms_cuentas.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;

//Response:Mapea los objetos que van del servidor hacia el cliente(respuestas)
public class CuentaResponse {


    private int cuentaId;
    private int tipoCuentaId;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private LocalDate fecha;

    public CuentaResponse(){}

    public CuentaResponse(int cuentaId, int tipoCuentaId, String numCuenta, String clabe, double saldo, LocalDate fecha) {
        this.cuentaId = cuentaId;
        this.tipoCuentaId = tipoCuentaId;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.fecha = fecha;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
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
                "cuentaId=" + cuentaId +
                ", tipoCuentaId=" + tipoCuentaId +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", fecha=" + fecha +
                '}';
    }
}
