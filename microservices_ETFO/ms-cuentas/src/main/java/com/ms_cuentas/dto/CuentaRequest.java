package com.ms_cuentas.dto;

import jakarta.validation.constraints.*;

//Modelo que captura los datos que vienen desde el cliente
//Es un DTO
public class CuentaRequest {

    private int cuentaId;

    @NotNull(message = "El cliente id no puede quedar nulo")
    @Positive(message = "No se permiten valores negativos")
    private Integer clienteId;

    @NotNull(message = "El tipo cuenta id no puede quedar nulo")
    @Positive(message = "No se permiten valores negativos")
    private Integer tipoCuentaId;

    @NotNull(message = "El saldo es requerido")
    @Positive(message = "No se permiten valores negativos")
    private double saldo;

    public CuentaRequest() { }

    public CuentaRequest(int cuentaId, Integer clienteId, Integer tipoCuentaId, double saldo) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.tipoCuentaId = tipoCuentaId;
        this.saldo = saldo;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
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
