public class Aplicacion {

    String nombre;
    String tipo;
    String version;
    double tamaño;
    boolean gratis;

    public Aplicacion(String nombre, String tipo, String version, double tamaño, boolean gratis) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.version = version;
        this.tamaño = tamaño;
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

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
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
                ", tamaño=" + tamaño +
                ", gratis=" + gratis +
                '}';
    }
}




