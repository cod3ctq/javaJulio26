package com.example.ms_transacciones.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TransaccionRequest {

    @NotBlank(message = "El número de tarjeta es requerido, no debe contener espacios en blanco")
    @Size(min = 16, max = 16, message = "El numero de tarjeta debe contener 16 digitos")
    private String numTarjeta;

    @Positive(message = "El monto debe ser un valor positivo")
    private double monto;

    public TransaccionRequest(String numTarjeta, double monto) {
        this.numTarjeta = numTarjeta;
        this.monto = monto;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "TransaccionRequest{" +
                "numTarjeta='" + numTarjeta + '\'' +
                ", monto=" + monto +
                '}';
    }
}
