/*
Clase:modelo o plantilla conceptual que expresa un QUÉ y un CÓMO
 */

import java.util.Arrays;

public class Tablet {

    //tamaño, color, forma, peso, aplicaciones, precio, cámara, marca, memoria sistema operativo
    double tamaño;
    String color;
    String forma;
    double peso;

    //Composición: relación donde un objeto se compone de otros más pequeños
    Aplicacion[] aplicaciones;
    Camara cam;

    double precio;
    String marca;
    int ram;
    String sistemaOperativo;

    /*Miembros por default
     */

    //Métodos constructor

    //Permite inicializar una instancia vacía del objeto
    public Tablet(){} // vacío

    //Generar: clic derecho-Generate-Constructor- seleccionar todos (ctrl + A)/ OK
    public Tablet(double tamaño, String color, String forma, double peso, double precio, String marca, int ram, String sistemaOperativo) {
        this.tamaño = tamaño;
        this.color = color;
        this.forma = forma;
        this.peso = peso;
        this.precio = precio;
        this.marca = marca;
        this.ram = ram;
        this.sistemaOperativo = sistemaOperativo;
    }

    public Tablet(double tamaño, String color, String forma, double peso, Aplicacion[] aplicaciones, Camara cam, double precio, String marca, int ram, String sistemaOperativo) {
        this.tamaño = tamaño;
        this.color = color;
        this.forma = forma;
        this.peso = peso;
        this.aplicaciones = aplicaciones;
        this.cam = cam;
        this.precio = precio;
        this.marca = marca;
        this.ram = ram;
        this.sistemaOperativo = sistemaOperativo;
    }

    //Generar: clic derecho-Generate-getter and setter/marcar todos (ctrl + A)/ OK
    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Aplicacion[] getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(Aplicacion[] aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    public Camara getCam() {
        return cam;
    }

    public void setCam(Camara cam) {
        this.cam = cam;
    }

    //Generar: clic derecho-toString()/marcar todos (ctrl + A)/ OK
    //Permite ver el estado del objeto

    @Override
    public String toString() {
        return "Tablet{" +
                "tamaño=" + tamaño +
                ", color='" + color + '\'' +
                ", forma='" + forma + '\'' +
                ", peso=" + peso +
                ", aplicaciones=" + Arrays.toString(aplicaciones) +
                ", cam=" + cam +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", ram=" + ram +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                '}';
    }
}
