public class TecnicoIT extends  Empleado implements ISoporteTecnico,IRecursosHumanos {
    String credencialAcceso;

    public TecnicoIT (){}

    public TecnicoIT(String rfc, String nombre, int aniosExo, String numEmpleado, String credencialAcceso) {
        super(rfc, nombre, aniosExo, numEmpleado);
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
                ", aniosExo=" + aniosExo +
                ", numEmpleado='" + numEmpleado + '\'' +
                '}';
    }

    //METODOS DE LA FORMA 3: TRAIDOS DE INTERFACES
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
