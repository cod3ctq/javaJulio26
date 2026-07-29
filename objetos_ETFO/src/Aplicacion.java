public class Aplicacion {
    String nombre;
    String tipo;
    String version;
    double tamanio;
    boolean gratis;

    public Aplicacion() { }

    public Aplicacion(String nombre, String tipo, String version, double tamanio, boolean gratis) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.version = version;
        this.tamanio = tamanio;
        this.gratis = gratis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public boolean isGratis() {
        return gratis;
    }

    public void setGratis(boolean gratis) {
        this.gratis = gratis;
    }

    @Override
    public String toString() {
        return "Aplicacion{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", version='" + version + '\'' +
                ", tamanio=" + tamanio +
                ", gratis=" + gratis +
                '}';
    }
}
