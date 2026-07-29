public class BoletoAvion extends Boleto{

            String origen;
            String destino;
            String asiento;
            String terminal;
            String horallegada;
            String horasalida;
            String cliente;
            double kilosDocumentados;

            public BoletoAvion(){}

    public BoletoAvion(String folio, String fecha, double precio, String origen,
                       String destino, String asiento, String terminal, String
                               horallegada, String horasalida, String cliente, double kilosDocumentados) {
        super(folio, fecha, precio);
        this.origen = origen;
        this.destino = destino;
        this.asiento = asiento;
        this.terminal = terminal;
        this.horallegada = horallegada;
        this.horasalida = horasalida;
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

    public String getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(String horallegada) {
        this.horallegada = horallegada;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
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
                ", horallegada='" + horallegada + '\'' +
                ", horasalida='" + horasalida + '\'' +
                ", cliente='" + cliente + '\'' +
                ", kilosDocumentados=" + kilosDocumentados +
                ", folio='" + folio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}
