public class Empleado {

    String rfc;
    String nombre;
    int aniosExp;
    String numEmpleado;

    public Empleado (){}

    public Empleado(String rfc, String nombre, int aniosExp, String numEmpleado) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.aniosExp = aniosExp;
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

    public int getAniosExp() {
        return aniosExp;
    }

    public void setAniosExp(int aniosExp) {
        this.aniosExp = aniosExp;
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
                ", aniosExp=" + aniosExp +
                ", numEmpleado='" + numEmpleado + '\'' +
                '}';
    }

    public void checarEntrada(){
        System.out.println("Insertar tarjeta en reloj checador");
    }
}
