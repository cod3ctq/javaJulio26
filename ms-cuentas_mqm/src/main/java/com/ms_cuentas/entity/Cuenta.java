package com.ms_cuentas.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

//Entidad: CLase que representa una tabla de base de datos

//Serializacion es la desintegracion del estado de un objeto en bytes
//donde se reciba se hace la DESERIALIZACION:
// la reconstruccion del estado del objeto en bytes

@Entity //convierte la clase POJO en una entidad
@Table(name = "CUENTAS") // enlaza esta clase con la tabla
public class Cuenta implements Serializable {

    @Id //identificacion de la llave primaria, la unica anotacion para lallave
    //enlaza el atributo con la columna que representa, nombre y tipo de dato
    @Column(name = "CUENTA_ID",columnDefinition = "NUMBER")
    //indicar como se genera este dato
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaId;

    @Column(name = "CLIENTE_ID", columnDefinition = "NUMBER")
    private int clienteId;
    @Column(name = "TIPO_CUENTA_ID", columnDefinition = "NUMBER")
    private int tipoCuentaId;
    @Column(name = "NUM_CUENTA", columnDefinition = "VARCHAR2(10)")
    private String numCuenta;
    @Column(name = "CLABE", columnDefinition = "CHAR(18)")
    private String clabe;
    @Column(name = "SALDO", columnDefinition = "NUMBER(8,2)")
    private double saldo;
    @Column(name = "FECHA_AP", columnDefinition = "DATE")
    private LocalDate fecha;
    @Column(name = "STATUS", columnDefinition = "CHAR(1)")
    private char status;

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "cuentaId=" + cuentaId +
                ", clienteId=" + clienteId +
                ", tipoCuentaId=" + tipoCuentaId +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", fecha=" + fecha +
                ", status=" + status +
                '}';
    }
}
