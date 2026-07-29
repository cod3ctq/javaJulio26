import java.util.Arrays;

//Una clase es un modelo o plantilla conceptual, que expresa un QUE y un COMO
public class Tablet { //es nuestro objeto

    //Atributos de una tablet: //Atributos del objeto
    double tamaño;
    String color;
    String forma;
    Double peso;
    //Se pueden asignar atributos mas complejos en forma de arrays. Se les conoce como composicion.
    String[] aplicaciones;

    double precio;
    //Composicion: relacion donde un objeto se compone de otros mas pequeños
    //Es un atributo complejo, un atributo de la clase Camara que nosotros declaramos y le dimos sus atributos, no hay limite de cuantos objetos de objetos se pueden hacer
    Camara cam;

    String marca;
    int ram;
    String sistemaOperativo;

    //Miembros por default

    //metodo constructor: Es vacio pues en sus llaves no tiene nada, permite inicializar una instancia vacia del objeto
    public Tablet(){} //Vacio

    //Generar metodo constructor lleno:
    //Click derecho-> Generate-> constructor/seleccionar todos/OK
    public Tablet(double tamaño, String color, String forma, Double peso, double precio, String marca, int ram, String sistemaOperativo) {
        this.tamaño = tamaño;
        this.color = color;
        this.forma = forma;
        this.peso = peso;
        this.precio = precio;
        this.marca = marca;
        this.ram = ram;
        this.sistemaOperativo = sistemaOperativo;
    }

    //Cuando se asignan mas atributos despues de haber generado los metodos, se pueden volver a generar para agregar esos nuevos atributos
    //Ambos metodos pueden existir y usarse, se declara uno o el otro basandose en su forma, el orden y los tipos de los atributos
    public Tablet(double tamaño, String color, String forma, Double peso, String[] aplicaciones, double precio, Camara cam, String marca, int ram, String sistemaOperativo) {
        this.tamaño = tamaño;
        this.color = color;
        this.forma = forma;
        this.peso = peso;
        this.aplicaciones = aplicaciones;
        this.precio = precio;
        this.cam = cam;
        this.marca = marca;
        this.ram = ram;
        this.sistemaOperativo = sistemaOperativo;
    }

    //Generarlo:
    //Click derecho-> Generate-> getter and setter/seleccionar todos/OK
    //Metodos Getter y Setter

    //Getter: extraen/devuelven un valor de algun atributo especifico
    //Los getter se llaman:
    //sout(t1.getPrecio()); //t1 es el objeto del que solicitamos el atributo, .getPrecio es el metodo que lo asigna, () queda vacio

    //Setter: establecen un valor al interior del objeto
    //Los setter se llaman:
    //t1.setPrecio(7500); //t1 en este caso es el objeto al que le asignaremos el atributo, .setPrecio es el metodo que lo asigna, (7500) es el valor asignado

    //Los metodos que NO son void devuelen algo, estan definidos con el tipo de dato del valor que devuelven, tienen reservada la palabra "return"
    //(public double, public String, public int, etc)
    public double getTamaño() {
        return tamaño;
    }

    //Todos los public void son los metodos que no te devuelven nada, tienen reservada la palabra "this"
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
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

    //Cuando se agregan atributos se deben generar esos nuevos atributos
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

    //Generarlo:
    //Click derecho-> Generate-> toString()/OK
    //Permite ver el estado del objeto
    //Cuando se agregan atributos se debe volver a generar
    @Override
    public String toString() {
        return "Tablet{" +
                "tamaño=" + tamaño +
                ", color='" + color + '\'' +
                ", forma='" + forma + '\'' +
                ", peso=" + peso +
                ", aplicaciones=" + Arrays.toString(aplicaciones) +
                ", precio=" + precio +
                ", cam=" + cam +
                ", marca='" + marca + '\'' +
                ", ram=" + ram +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                '}';
    }
}
