//Clase: Es un modelo o plantilla conceptual que expresa un QUE y un COMO

import java.util.Arrays;

public class Tablet {
double tamaño;
String color;
String forma;
double peso;
//Composicion: relacion en donde un objeto se compone de otros objetos mas pequeños.
    // aplicaciones: como son muchas aplicaciones mejor se realiza un Array de Strings
//    String galeria;
//    String facebook;
//    String x;
//    String musica;
String[] aplicaciones;// como todas son de tipo Strin, se hace un array de strings
    //camara : resolucion, tipoLente, zoom, tipoZoom,-#cams, flash
Camara cam ;
    double precio;
String marca;
int ram;
String sistemaOperativo;

//Miembros por default
    //1.-METODO CONSTRUCTOR/////

    //permite inicializar una instancia vacia del objeto.
    public Tablet(){} // vacio

//Generarlo: clic derecho en pantalla -> generate ->constructor/marcar todos ctrl + a/ Ok
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

//NUEVO CONSTRUCTOR AGREGANDO CAMARA Y EL STRING DE APLICACIONES:
    public Tablet(double tamaño, String color, String forma, double peso, String[] aplicaciones, Camara cam, double precio, String marca, int ram, String sistemaOperativo) {
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

    //Generarlo: clic derecho en pantalla -> Generate --> getter and setter/ marcar todos ctrl +a/ok
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

    //NUEVO GETTER AND SETTER CON CAMARA Y STRING DE APLICACIONES AGREGADO

    //Generarlo: clic derecho en pantalla -> generate ->toString()/marcar todos ctrl + a/ Ok

    public String[] getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(String[] aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    public Camara getCam() {
        return cam;
    }

    public void setCam(Camara cam) {
        this.cam = cam;
    }

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
