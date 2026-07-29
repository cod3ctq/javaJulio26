//CLASE PADRE////

public class Boleto {
    String folio;
    String fecha;
    double precio;

    public Boleto (){}

    //constructor

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
