import java.util.Arrays;

//clase: modelo o plantilla conceptual
//que expresa un que y un como
public class Tablet {
    //para una clase se necesita un atributo que describe el objeto de la clase
    double tamaño;
    String color;
    String forma;
    double peso;

    //app,//galeria, facebook, camara, etc
    // este atributo presenta muchos atributos propios, se puede asignar a un array
    //genera una complejidad
    String[] aplicaciones;

    //camara,//resolucion, tipoLente, zoom, tipoZoom, #camaras, flash
    //la complejidad de app y camara estan siendo catalogadas
    // como objeto por la cantidad de atributos que presenta
    Camara cam;//Composicion: relacion donde un objeto se compone de otros mas pequeños

    double precio;
    String marca;
    int ram;
    String sistemaOperativo;

    //MIEMBROS POR DEFAULT de una clase
    //1-metodo constructor

    //este permite inicializar una instancia vacia del objeto
    public Tablet(){}//constructor vacio

    //clic derecho->generate->constructor->ctrl+a(marcas todos)->ok
    public Tablet(double tamaño, String color, String forma, double peso,
                  double precio, String marca, int ram, String sistemaOperativo) {
        this.tamaño = tamaño;
        this.color = color;
        this.forma = forma;
        this.peso = peso;
        this.precio = precio;
        this.marca = marca;
        this.ram = ram;
        this.sistemaOperativo = sistemaOperativo;
    }

    //dentro de los constructores, el primero no se encuentro familiarizado con los
    // nuevos atributos por lo que se genera un nuevo constructor, getter y setters y to string:
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


    // generarlo: clic derecho->generate->getter and setter->marcar todos->ok
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
