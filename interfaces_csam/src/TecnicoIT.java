public class TecnicoIT extends Empleado implements ITSoporteTecnico{
    String credencialAcesso;

    public TecnicoIT(){}

    public TecnicoIT(String rfc, String nombre, int aniosExp, String numeroEmepleado, String credencialAcesso) {
        super(rfc, nombre, aniosExp, numeroEmepleado);
        this.credencialAcesso = credencialAcesso;
    }

    public String getCredencialAcesso() {
        return credencialAcesso;
    }

    public void setCredencialAcesso(String credencialAcesso) {
        this.credencialAcesso = credencialAcesso;
    }

    @Override
    public String toString() {
        return "TecnicoIT{" +
                "credencialAcesso='" + credencialAcesso + '\'' +
                ", rfc='" + rfc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aniosExp=" + aniosExp +
                ", numeroEmepleado='" + numeroEmepleado + '\'' +
                '}';
    }

    //Metodos de la forma 3: Traidos de las interface
    @Override
    public void mantener() {

    }

    @Override
    public void gertionarEquipos() {

    }

    @Override
    public void configurar() {

    }

    @Override
    public void generarReportesIncidencias() {

    }
}
