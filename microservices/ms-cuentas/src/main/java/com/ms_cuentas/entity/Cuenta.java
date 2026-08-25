package com.ms_cuentas.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
//Entidad: Clase que representa una tabla de base de datos.

@Entity //Convierte la clase POJO en una Entidad
@Table(name = "CUENTAS") //Enlaza esta clase con la tabla
public class Cuenta implements Serializable { //Serialización: Desinteagración del estado de un objeto en bytes
    //Deserialización: Reconstrucción del estado del objeto en bytes

    @Id
    @Column(name = "CUENTA_ID", columnDefinition = "NUMBER") //Enlaza el atributo con la columna que representa
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicar cómo se genera este dato
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
}
