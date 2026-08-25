package com.ms_transacciones.dto;

public class DepositoRequest {

    private String numTarjeta;
    private String numTarjetaDeposito;
    private double monto;

    public DepositoRequest() { }

    public DepositoRequest(String numTarjeta, String numTarjetaDeposito, double monto) {
        this.numTarjeta = numTarjeta;
        this.numTarjetaDeposito = numTarjetaDeposito;
        this.monto = monto;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNumTarjetaDeposito() {
        return numTarjetaDeposito;
    }

    public void setNumTarjetaDeposito(String numTarjetaDeposito) {
        this.numTarjetaDeposito = numTarjetaDeposito;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
