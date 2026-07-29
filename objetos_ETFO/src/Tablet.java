import java.util.Arrays;

//Clase: Modelo o plantilla conceptual que expresa un QUE y COMO
//Herencia, encapsulamiento, polimorfismo, abtraccion y un quinto concepto poco utlizado: composicion
public class Tablet {

    // Tamaño, Color, Forma, Peso, Aplicaciones, Precio, Camara, Marca
    // ram, Sistema Operativo

    double tamanio;
    String color;
    String forma;
    double peso;
    //aplicaciones
    Aplicacion [] aplicaciones;
    double precio;
    //Composicion: Es una relacion en donde un objeto se compone de otros mas pequeños
    Camara cam; //Objeto complejo <-----> Composicion
    String marca;
    int ram;
    String sistemaOperativo;

    //Miembros por default
    //Metodos constructor

    //Permite inicializar una instancia vacia del objeto
    public Tablet() {}// Constructor vacio

    //Generate: clic derecho -> Generate -->constructor/marcar todos/ok
    public Tablet(double tamanio, String color, String forma, double peso, double precio, String marca, int ram, String sistemaOperativo) {
        this.tamanio = tamanio;
        this.color = color;
        this.forma = forma;
        this.peso = peso;
        this.precio = precio;
        this.marca = marca;
        this.ram = ram;
        this.sistemaOperativo = sistemaOperativo;
    }

    public Tablet(double tamanio, String color, String forma, double peso, Aplicacion[] aplicaciones, double precio, Camara cam, String marca, int ram, String sistemaOperativo) {
        this.tamanio = tamanio;
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
    //Lo de los constructores es polimorfismo cada uno tiene una cantidad de atributos distinta...

    //Generate: clic derecho -> Generate -->getter and setter/marcar todos/ok
    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
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

    //Generarlo: Clic derecho -> Generate --> toString()/Ok
    //Permite ver el estado del objeto
    //IMPORTANTE: es importante actualizar el toString() ya que si actualizamos las intancias y o el toString() el estado del objeto seguira siendo lo mismo que el "anterior"


    @Override
    public String toString() {
        return "Tablet{" +
                "tamanio=" + tamanio +
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
