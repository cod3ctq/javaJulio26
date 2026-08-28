package com.ms_cuentas.dto;
//Modelo que captura los datos que vienen desde el cliente
//Es un DTO


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CuentaRequest {
    private int cuentaId;
    @NotNull(message = "El cliente id no puede quedar nulo")
    @Positive(message = "No se permiten valore snegativos")
    private Integer clienteId;

    @NotNull(message = "El  id de tipo cuenta no puede quedarnulo")
    @Positive(message = "No se permiten valores negativos")
    private Integer tipoCuentaId;

    @NotNull(message = "El saldo es requerido")
    @Positive(message = "No se permite saldos negativos")
    private double saldo;

    public CuentaRequest() {
    }

    public CuentaRequest(int cuentaId, Integer clienteId, Integer tipoCuentaId, double saldo) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.tipoCuentaId = tipoCuentaId;
        this.saldo = saldo;
    }

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
