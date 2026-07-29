public class BoletoAvion extends Boleto{

    String origen;
    String destino;
    String asientp;
    String terminal;
    String horaLlegada;
    String horaSalida;
    String cliente;
    Double kilosDocumentados;

    public BoletoAvion(String folio, String fecha, double precio, String origen, String destino, String asientp, String terminal, String horaLlegada, String horaSalida, String cliente, Double kilosDocumentados) {
        super(folio, fecha, precio);
        this.origen = origen;
        this.destino = destino;
        this.asientp = asientp;
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

    public String getAsientp() {
        return asientp;
    }

    public void setAsientp(String asientp) {
        this.asientp = asientp;
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

    public Double getKilosDocumentados() {
        return kilosDocumentados;
    }

    public void setKilosDocumentados(Double kilosDocumentados) {
        this.kilosDocumentados = kilosDocumentados;
    }

    @Override
    public String toString() {
        return "BoletoAvion{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", asientp='" + asientp + '\'' +
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
