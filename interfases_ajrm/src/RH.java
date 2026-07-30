public class RH extends Empleado implements IRecursosHumanos{

    String numeroTelefonico;


    public RH(){}

    public RH(String rfc, String nombre, int aniosExp, String numEmpleado, String numeroTelefonico) {
        super(rfc, nombre, aniosExp, numEmpleado);
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    @Override
    public String toString() {
        return "RH{" +
                "numeroTelefonico='" + numeroTelefonico + '\'' +
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
