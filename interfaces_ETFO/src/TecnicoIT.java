public class TecnicoIT extends Empleado implements ISoporteTecnico, IRecursosHumanos{
//public class TecnicoIT extends Empleado implements ISoporteTecnico, IRecursosHumanos -----> Se puede
    String credencilAcceso;

    public TecnicoIT() { }

    public TecnicoIT(String rfc, String nombre, double aniosExp, String numeroEmpleado, String credencilAcceso) {
        super(rfc, nombre, aniosExp, numeroEmpleado);
        this.credencilAcceso = credencilAcceso;
    }

    public String getCredencilAcceso() {
        return credencilAcceso;
    }

    public void setCredencilAcceso(String credencilAcceso) {
        this.credencilAcceso = credencilAcceso;
    }

    @Override
    public String toString() {
        return "TecnicoIT{" +
                "credencilAcceso='" + credencilAcceso + '\'' +
                ", rfc='" + rfc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aniosExp='" + aniosExp + '\'' +
                ", numeroEmpleado='" + numeroEmpleado + '\'' +
                '}';
    }

    //Metodos de la forma 3: Traidos de interfaces
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
