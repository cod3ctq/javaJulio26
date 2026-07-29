public class BoletoEstacionamiento extends Boleto{

    String horaEntrada;
    String placas;
    double precoHora;

    public BoletoEstacionamiento(String folio, String fecha, double precio, String horaEntrada, String placas, double precoHora) {
        super(folio, fecha, precio);
        this.horaEntrada = horaEntrada;
        this.placas = placas;
        this.precoHora = precoHora;
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

    public double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

    @Override
    public String toString() {
        return "BoletoEstacionamiento{" +
                "horaEntrada='" + horaEntrada + '\'' +
                ", placas='" + placas + '\'' +
                ", precoHora=" + precoHora +
                ", folio='" + folio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}
