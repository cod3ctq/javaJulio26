//Clase padre: Establece un modelo
//Aunque no se vea si se esta heredando, de la clase Object; Object <> la clase madre de todas
public class Boleto {

    String folio;
    String fecha;
    double precio;

    public Boleto () { } //Aunque no se declara de cierto modo funciona debido a Object

    public Boleto(String folio, String fecha, double precio) {
        this.folio = folio;
        this.fecha = fecha;
        this.precio = precio;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "folio='" + folio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
