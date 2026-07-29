import java.util.Arrays;

//Clase: Modelo o plantillaconseptual que expresa un QUE y COMO (se comporta)
public class Tablet {

    double tamaño;
    String color;
    String forma;
    double peso;
    double precio;
    String marca;
    int ram;
    String sistemaOperativo;
    //Comprosicion:relacion dnde un obketo se compone de otros mas pequeños
    String[] aplicaciones;
    Camara cam;


    //miembros por default
    //metodo constructor

    //Permite inicializar una istancia vacia del objeto
    public Tablet (){} //vacio
  //Generarlo: clic dereho/Generate-->constructor/marcar todos /ok


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

    public Tablet(double tamaño, String color, String forma, double peso, double precio, String marca, int ram, String sistemaOperativo, String[] aplicaciones, Camara cam) {
        this.tamaño = tamaño;
        this.color = color;
        this.forma = forma;
        this.peso = peso;
        this.precio = precio;
        this.marca = marca;
        this.ram = ram;
        this.sistemaOperativo = sistemaOperativo;
        this.aplicaciones = aplicaciones;
        this.cam = cam;
    }
    //Generarlo: clic dereho/Generate-->getter and setter /marcar todos /ok


    public double getPeso() {
        return peso;
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
    } //void metodos que no devuelven nada

    public double getPeso(double peso) {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    } // getter: extraen /duvuelvebunvslor de algun atributo espcificoo

    public void setPrecio(double precio) {
        this.precio = precio;
    } //seter establecen/inyectan un valor al inetrior del objetoo

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

    //Generarlo: clic dereho/Generate-->toString() /ok

    @Override
    public String toString() {
        return "Tablet{" +
                "tamaño=" + tamaño +
                ", color='" + color + '\'' +
                ", forma='" + forma + '\'' +
                ", peso=" + peso +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", ram=" + ram +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", aplicaciones=" + Arrays.toString(aplicaciones) +
                ", cam=" + cam +
                '}';
    }
}

