public class TecnicoIT extends Empleado implements ISoporteTecnico, IRecursosHumanos{

    String credencialAcceso;

    public TecnicoIT (){}

    public TecnicoIT(String rfc, String nombre, int aniosExp, String numEmpleado, String credencialAcceso) {
        super(rfc, nombre, aniosExp, numEmpleado);
        this.credencialAcceso = credencialAcceso;
    }

    public String getCredencialAcceso() {
        return credencialAcceso;
    }

    public void setCredencialAcceso(String credencialAcceso) {
        this.credencialAcceso = credencialAcceso;
    }

    @Override
    public String toString() {
        return "TecnicoIT{" +
                "credencialAcceso='" + credencialAcceso + '\'' +
                ", rfc='" + rfc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aniosExp=" + aniosExp +
                ", numEmpleado='" + numEmpleado + '\'' +
                '}';
    }

    //metodos de la forma 3: traidos de interfaces
    @Override
    public void mantener() {

    }

    @Override
    public void gestionarEquipos() {

    }

    @Override
    public void configurar() {

    }

    @Override
    public void generarReportesIncidencias() {

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
