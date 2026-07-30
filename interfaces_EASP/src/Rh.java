public class Rh extends Empleado implements IRecursosHumanos {

    String numeroTelefono;

    public Rh (){}

    public Rh(String rfc, String nombre, int aniosExp, String numEmpleado, String numeroTelefono) {
        super(rfc, nombre, aniosExp, numEmpleado);
        this.numeroTelefono = numeroTelefono;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return "Rh{" +
                "numeroTelefono='" + numeroTelefono + '\'' +
                ", rfc='" + rfc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aniosExp=" + aniosExp +
                ", numEmpleado='" + numEmpleado + '\'' +
                '}';
    }


    @Override
    public void reclutar() {

    }

    @Override
    public void entrevistar() {

    }

    @Override
    public void gestionarExpedientes() {

    }

    @Override
    public void capacitar() {

    }
}
