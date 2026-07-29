//Clase padre
// aqui, aunque no se ve se están heredando atributos de la clase objerts
public class Boleto {

    //Clase padre:
    String folio;
    String fecha;
    double precio;

    public Boleto(String folio, String fecha, double precio) {
        this.folio = folio;
        this.fecha = fecha;
        this.precio = precio;
    }

    public Boleto() {

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
