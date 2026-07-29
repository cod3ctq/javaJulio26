public class BoletoEstacionamiento extends Boleto{

    String horaEntrada;
    String placas;
    String precioHora;
    String horaSalida;

    public BoletoEstacionamiento(){}

    public BoletoEstacionamiento(String folio, String fecha, double precio, String horaEntrada, String placas, String precioHora, String horaSalida) {
        super(folio, fecha, precio);//invoca al constructor de la clase padre
        this.horaEntrada = horaEntrada;
        this.placas = placas;
        this.precioHora = precioHora;
        this.horaSalida = horaSalida;
    }

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

    public String getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(String precioHora) {
        this.precioHora = precioHora;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "BoletoEstacionamiento{" +
                "horaEntrada='" + horaEntrada + '\'' +
                ", placas='" + placas + '\'' +
                ", precioHora='" + precioHora + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", folio='" + folio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}
