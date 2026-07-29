public class BoletoEstacionamiento extends Boleto{

    String horaEntrada;
    String placas;
    double precioHora;
    String horaSalida;

    public BoletoEstacionamiento(){}

    /// ///////////CONSTRUCTOR
    public BoletoEstacionamiento(String folio, String fecha, double precio, String horaEntrada, String placas, double precioHora, String horaSalida) {
        super(folio, fecha, precio); //Super: invoca al constructor de la clase padre.
        this.horaEntrada = horaEntrada;
        this.placas = placas;
        this.precioHora = precioHora;
        this.horaSalida = horaSalida;
    }

    /// //////////////////////////SETTER AND GETTER
    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    /// //////////////////////////////////////////////////toString()
    @Override
    public String toString() {
        return "BoletoEstacionamiento{" +
                "horaEntrada='" + horaEntrada + '\'' +
                ", placas='" + placas + '\'' +
                ", precioHora=" + precioHora +
                ", horaSalida='" + horaSalida + '\'' +
                ", folio='" + folio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}
