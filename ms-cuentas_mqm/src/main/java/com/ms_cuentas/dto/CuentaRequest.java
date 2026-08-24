package com.ms_cuentas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

//Modelo que capruta los datos que vienen desde el cliente, es un DTO
public class CuentaRequest {

    private int cuentaId;

    @NotNull(message="El cliente id no puede ser nulo")
    @Positive(message = "No se permiten valores negativos")
    private Integer clienteId;

    @NotNull(message="El tipo de cuenta id no puede ser nulo")
    @Positive(message = "No se permiten valores negativos")
    private Integer tipoCuentaId;

    @NotNull(message = "EL saldo es requerido")
    @Positive(message = "No se permite saldos negativo")
    private double saldo;

    public CuentaRequest(int cuentaId, Integer clienteId, Integer tipoCuentaId, double saldo) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.tipoCuentaId = tipoCuentaId;
        this.saldo = saldo;
    }

    public CuentaRequest (){}

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getTipoCuentaId() {
        return tipoCuentaId;
    }

    public void setTipoCuentaId(Integer tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaRequest{" +
                "cuentaId=" + cuentaId +
                ", clienteId=" + clienteId +
                ", tipoCuentaId=" + tipoCuentaId +
                ", saldo=" + saldo +
                '}';
    }
}
