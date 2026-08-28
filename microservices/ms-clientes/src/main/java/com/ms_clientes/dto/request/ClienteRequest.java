package com.ms_clientes.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
//Esto espera recibir el back desde Angular, al registrar unu nuevo cliente ....
public class ClienteRequest {
    private int clienteId;
    @NotBlank(message="El nombre no debe quedar nulo ni vacio")
    @Size(max = 30, message="El nombre no debe superar los 30 caracteres")
    private String nombre; //No nulo ni vacio, 30 caracteres maximo
    @NotBlank(message="El apellido paterno no debe quedar nulo ni vacio")
    @Size(max = 30, message="El apellido paterno no debe superar los 30 caracteres")
    private String apP; //No nulo ni vacio, 30 caracteres maximo
    @NotBlank(message="El apellido materno no debe quedar nulo ni vacio")
    @Size(max = 30, message="El apellido materno no debe superar los 30 caracteres")
    private String apM; //No nulo ni vacio, 30 caracteres maximo
    @NotBlank(message="La direccion no debe quedar nulo ni vacio")
    @Size(max = 100, message="La direccion no debe superar los 100 caracteres")
    private String direccion; //No nulo ni vacio, 100 caracteres maximo
    @NotBlank(message="El telefono no debe quedar nulo ni vacio")
    @Size(max = 10, message="El telefono no debe superar los 10 caracteres")
    private String telefono; //No nulo ni vacio, 10 caracteres maximo
    @NotBlank(message="El correo no debe quedar nulo ni vacio")
    @Size(max = 50, message="El correo no debe superar los 50 caracteres")
    private String correo; //No nulo ni vacio, 50 caracteres maximo
    //@NotBlank(message="El ine no debe quedar nulo ni vacio")
    @Size(min = 18, max = 18, message="El ine debe tener 18 caracteres")
    private String ine; //No nulo ni vacio, 18 caracteres
    //@NotBlank(message="El rfc no debe quedar nulo ni vacio")
    @Size(min = 13, max = 13, message="El rfc debe tener  13 caracteres")
    private String rfc; //No nulo ni vacio, 13 caracteres
    //@NotNull(message = "La fecha de nacimiento es requerida")
    @Past(message = "Debe ser una fecha del pasado")
    private LocalDate fechaNac; //No nulo, debe ser fecha del pasado

    public ClienteRequest(){}

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

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

    @Override
    public String toString() {
        return "ClienteRequest{" +
                "clienteId=" + clienteId +
                ", nombre='" + nombre + '\'' +
                ", apP='" + apP + '\'' +
                ", apM='" + apM + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", ine='" + ine + '\'' +
                ", rfc='" + rfc + '\'' +
                ", fechaNac=" + fechaNac +
                '}';
    }
}
