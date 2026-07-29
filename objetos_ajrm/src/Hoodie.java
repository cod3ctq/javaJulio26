import java.awt.*;

public class Hoodie {

    double precio;
    String color;
    String talla;
    boolean estampado;
    String sexo;
    String marca;

        public Hoodie(){}

         public Hoodie(double precio, String color, String talla, boolean estampado, String sexo, String marca) {
             this.precio = precio;
                this.color = color;
                this.talla = talla;
                this.estampado = estampado;
                this.sexo = sexo;
                this.marca = marca;
            }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

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

    public boolean isEstampado() {
        return estampado;
    }

    public void setEstampado(boolean estampado) {
        this.estampado = estampado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Hoodie{" +
                "precio=" + precio +
                ", color='" + color + '\'' +
                ", talla='" + talla + '\'' +
                ", estampado=" + estampado +
                ", sexo='" + sexo + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
