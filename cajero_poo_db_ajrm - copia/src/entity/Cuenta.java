package entity;

import java.util.Date;

//El proposito de esta clase es representar la estructura de una tabla de base de datos.
//Entidad
public class Cuenta {

    private int cuentaId;
    private int clienteId;
    private int tipoCuentaId;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private Date fechaAp;
    private char status;


    public Cuenta(int cuentaId, int clienteId, int tipoCuentaId, String numCuenta, String clabe, double saldo, Date fechaAp, char status) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.tipoCuentaId = tipoCuentaId;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.fechaAp = fechaAp;
        this.status = status;
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


    @Override
    public String toString() {
        return "entity.Cuenta{" +
                "cuentaId=" + cuentaId +
                ", clienteId=" + clienteId +
                ", tipoCuentaId=" + tipoCuentaId +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", fechaAp=" + fechaAp +
                ", status=" + status +
                '}';
    }
}
