public class BoletoAvion extends Boleto {
    String origen;
    String destino;
    String asiento;
    String terminal;
    String horaLlegada;
    String horaSalida;
    String cliente;
    double kilosDocumentados;

    public BoletoAvion(){

    }

    public BoletoAvion(String folio, String fecha, double precio, String origen, String destino, String asiento, String terminal, String horaLlegada, String horaSalida, String cliente, double kilosDocumentados) {
        super(folio, fecha, precio);
        this.origen = origen;
        this.destino = destino;
        this.asiento = asiento;
        this.terminal = terminal;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.cliente = cliente;
        this.kilosDocumentados = kilosDocumentados;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getKilosDocumentados() {
        return kilosDocumentados;
    }

    public void setKilosDocumentados(double kilosDocumentados) {
        this.kilosDocumentados = kilosDocumentados;
    }

    @Override
    public String toString() {
        return "BoletoAvion{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", asiento='" + asiento + '\'' +
                ", terminal='" + terminal + '\'' +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", cliente='" + cliente + '\'' +
                ", kilosDocumentados=" + kilosDocumentados +
                ", folio='" + folio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}
