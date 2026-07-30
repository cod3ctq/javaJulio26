public class Empleado {
    String rfc;
    String nombre;
    int aniosExo;
    String numEmpleado;

    public Empleado(){}

    public Empleado(String rfc, String nombre, int aniosExo, String numEmpleado) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.aniosExo = aniosExo;
        this.numEmpleado = numEmpleado;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAniosExo() {
        return aniosExo;
    }

    public void setAniosExo(int aniosExo) {
        this.aniosExo = aniosExo;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "rfc='" + rfc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aniosExo=" + aniosExo +
                ", numEmpleado='" + numEmpleado + '\'' +
                '}';
    }

    @Override
    public void checarEntrada() {

    }
}
