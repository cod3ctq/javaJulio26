package dto;

import java.util.Date;

// DTO: Data Transfer Object
// Modelo flexible, pensado para enviar/recibir los datos que necesites permite modificar la estructura del objeto
public class CuentaDTO {

    private int cuentaId;
    private int clienteId;
    private int tipoCuentaId;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private Date fechaAp;
    private char status;
    String numTarjeta;
    double saldoMin;
    double saldoMax;

    public CuentaDTO(int cuentaId, int clienteId, int tipoCuentaId, String numCuenta, String clabe, double saldo, Date fechaAp, char status, String numTarjeta, double saldoMin, double saldoMax) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.tipoCuentaId = tipoCuentaId;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.fechaAp = fechaAp;
        this.status = status;
        this.numTarjeta = numTarjeta;
        this.saldoMin = saldoMin;
        this.saldoMax = saldoMax;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
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

    public Date getFechaAp() {
        return fechaAp;
    }

    public void setFechaAp(Date fechaAp) {
        this.fechaAp = fechaAp;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
    }

    @Override
    public String toString() {
        return "dto.CuentaDTO{" +
                "cuentaId=" + cuentaId +
                ", clienteId=" + clienteId +
                ", tipoCuentaId=" + tipoCuentaId +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", fechaAp=" + fechaAp +
                ", status=" + status +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                '}';
    }

}
