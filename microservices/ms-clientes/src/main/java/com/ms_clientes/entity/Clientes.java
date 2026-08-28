package com.ms_clientes.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTES")
public class Clientes implements Serializable {

    @Id
    @Column(name = "CLIENTE_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteId;
    @Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(255)")
    private String nombre;
    @Column(name = "AP_P", columnDefinition = "NVARCHAR2(255)")
    private String apP;
    @Column(name = "AP_M", columnDefinition = "NVARCHAR2(255)")
    private String apM;
    @Column(name = "DIRECCION", columnDefinition = "NVARCHAR2(255)")
    private String direccion;
    @Column(name = "TELEFONO", columnDefinition = "VARCHAR2(10)")
    private String telefono;
    @Column(name = "CORREO", columnDefinition = "NVARCHAR2(100)")
    private String correo;
    @Column(name = "INE", columnDefinition = "VARCHAR2(18)")
    private String ine;
    @Column(name = "RFC", columnDefinition = "VARCHAR2(13)")
    private String rfc;
    @Column(name = "FECHA_NAC", columnDefinition = "DATE")
    private LocalDate fechaNac;
    @Column(name = "STATUS", columnDefinition = "NUMBER")
    private int status;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApP() {
        return apP;
    }

    public void setApP(String apP) {
        this.apP = apP;
    }

    public String getApM() {
        return apM;
    }

    public void setApM(String apM) {
        this.apM = apM;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
