public class Ciudad {
    String codigoPostal;
    String nombre;
    int habitantes;
    String estado;
    String actividadEconomica;
    String clima;

    public Ciudad(){}

    public Ciudad(String codigoPostal, String nombre, int habitantes, String estado, String actividadEconomica, String clima) {
        this.codigoPostal = codigoPostal;
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.estado = estado;
        this.actividadEconomica = actividadEconomica;
        this.clima = clima;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "codigoPostal='" + codigoPostal + '\'' +
                ", nombre='" + nombre + '\'' +
                ", habitantes=" + habitantes +
                ", estado='" + estado + '\'' +
                ", actividadEconomica='" + actividadEconomica + '\'' +
                ", clima='" + clima + '\'' +
                '}';
    }
}
