public class Empleado {

    String rfc;
    String nombre;
    double aniosExp;
    String numeroEmpleado;

    public Empleado() { }

    public Empleado(String rfc, String nombre, double aniosExp, String numeroEmpleado) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.aniosExp = aniosExp;
        this.numeroEmpleado = numeroEmpleado;
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

    public double getAniosExp() {
        return aniosExp;
    }

    public void setAniosExp(double aniosExp) {
        this.aniosExp = aniosExp;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "rfc='" + rfc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aniosExp='" + aniosExp + '\'' +
                ", numeroEmpleado='" + numeroEmpleado + '\'' +
                '}';
    }

    public void checarEntrada(){
        System.out.println("Inserta la tarjeta en el reloj checador");
    }
}
