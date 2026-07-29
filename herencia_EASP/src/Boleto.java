
//Clase Padre: Establece un modelo base.
//Aunque no se vea, si se esta heredando de la clase Object, que es el padre de todas las clases.
//Las clases solo tienen un padre
public class Boleto {

    String folio;
    String fecha;
    double precio;

    public Boleto (){}

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
                ", precio=" + precio +
                '}';
    }
}
