public class Rh extends Empleado implements IRecursosHumanos{

    String numTelefono;

    public Rh (){}

    public Rh(String rfc, String nombre, int aniosExp, String numEmpleado, String numTelefono) {
        super(rfc, nombre, aniosExp, numEmpleado);
        this.numTelefono = numTelefono;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    @Override
    public String toString() {
        return "Rh{" +
                "numTelefono='" + numTelefono + '\'' +
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
