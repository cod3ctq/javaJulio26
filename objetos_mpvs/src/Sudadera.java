
public class Sudadera {
    String color;
    String talla;
    String marca;
    String estampado;
    double precio;
    String tamaño; //corta,larga
    boolean conGorro;
    String tipo;

    //permite inicializar una instancia vacia del objeto.
    public Sudadera(){}

    //constructor
    public Sudadera(String color, String talla, String marca, String estampado, double precio, String tamaño, boolean conGorro, String tipo) {
        this.color = color;
        this.talla = talla;
        this.marca = marca;
        this.estampado = estampado;
        this.precio = precio;
        this.tamaño = tamaño;
        this.conGorro = conGorro;
        this.tipo = tipo;
    }


    //getter and setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstampado() {
        return estampado;
    }

    public void setEstampado(String estampado) {
        this.estampado = estampado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isConGorro() {
        return conGorro;
    }

    public void setConGorro(boolean conGorro) {
        this.conGorro = conGorro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //toString
    @Override
    public String toString() {
        return "Sudadera{" +
                "color='" + color + '\'' +
                ", talla='" + talla + '\'' +
                ", marca='" + marca + '\'' +
                ", estampado='" + estampado + '\'' +
                ", precio=" + precio +
                ", tamaño='" + tamaño + '\'' +
                ", conGorro=" + conGorro +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
