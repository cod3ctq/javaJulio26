public class Empleado {
    String rfc;
    String nombre;
    int aniosExp;
    String numeroEmepleado;

    public Empleado(){}

    public Empleado(String rfc, String nombre, int aniosExp, String numeroEmepleado) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.aniosExp = aniosExp;
        this.numeroEmepleado = numeroEmepleado;
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

    public String getNumeroEmepleado() {
        return numeroEmepleado;
    }

    public void setNumeroEmepleado(String numeroEmepleado) {
        this.numeroEmepleado = numeroEmepleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "rfc='" + rfc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aniosExp=" + aniosExp +
                ", numeroEmepleado='" + numeroEmepleado + '\'' +
                '}';
    }

    public void checarEntrada(){
        System.out.println("Inserta la tarjeta en reloj del checador");
    }
}
