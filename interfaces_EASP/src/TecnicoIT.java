//Se pueden implementar mas de una interface a una Clase, simplemente separandolas con ","
public class TecnicoIT extends  Empleado implements ISoporteTecnico, IRecursosHumanos{

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

    //Debe implementar los metodos.
    //Se puede hacer seleccionando "Implement methods", al pasar por el error que marca al escribir "implemets", al declarar el objeto
    //Metodos de la forma 3: Traidos de interfaces
    @Override
    public void mantener() {
        //Aqui ahora si se dan las acciones a realizar
    }

    @Override
    public void gestionar() {

    }

    @Override
    public void configurar() {

    }

    @Override
    public void generarReportes() {

    }

    //Implementa ahora ademas la interface extra
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
