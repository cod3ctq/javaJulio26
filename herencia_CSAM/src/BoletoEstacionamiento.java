public class BoletoEstacionamiento  extends Boleto{
    String horaentrada;
    String plcas;
    double precioHora;
    String horaSalida;

    public BoletoEstacionamiento(){

    }

    public BoletoEstacionamiento(String folio, String fecha, double precio, String horaentrada, String plcas, double precioHora, String horaSalida) {
        super(folio, fecha, precio);
        this.horaentrada = horaentrada;
        this.plcas = plcas;
        this.precioHora = precioHora;
        this.horaSalida = horaSalida;
    }

    public String getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(String horaentrada) {
        this.horaentrada = horaentrada;
    }

    public String getPlcas() {
        return plcas;
    }

    public void setPlcas(String plcas) {
        this.plcas = plcas;
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

    @Override
    public String toString() {
        return "BoletoEstacionamiento{" +
                "horaentrada='" + horaentrada + '\'' +
                ", plcas='" + plcas + '\'' +
                ", precioHora=" + precioHora +
                ", horaSalida='" + horaSalida + '\'' +
                ", folio='" + folio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}
