public class Zapato {

    double talla;
    String color;
    String genero;
    String tipo;
    double precio;
    String marca;

    public Zapato(){}

    public Zapato(double talla, String color, String genero, String tipo, double precio, String marca) {
        this.talla = talla;
        this.color = color;
        this.genero = genero;
        this.tipo = tipo;
        this.precio = precio;
        this.marca = marca;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "Zapato{" +
                "talla=" + talla +
                ", color='" + color + '\'' +
                ", genero='" + genero + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                '}';
    }

    public void setMarca(String marca) {
        this.marca = marca;


    }
}
