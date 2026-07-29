/*
Clase: Modelo o plantilla conceptual que expresa
        un que y como se plantea

 */


import java.util.Arrays;

public class Tablet {

    //tamaño, color, forma, peso, aplicasiones, precio, camara,
    //marca, ram, sistema operativo

    double tamaño;
    String color;
    String forma;
    double peso;

    //composicion : relacion deonde un objeto se compone de otros mas pequeños:
    String [] aplicaciones;
    Camara cam;

    double precio;
    //camara
    String marca;
    int ram;
    String sistemaOperativo;

    // Miembros por default

    //metodo contructor




    //permite inicializar una intancia vacia del objeto;
    public Tablet(){} //vacio

    // generarlo: click derecho -> generate -> contructor /marcar todos/ ok

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


    // click derecho -> generate -> getter and setter /marcar todos/ ok

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


    //click derecho -> generate -> toString()/ ok

    //permite ver el estado del objeto

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
