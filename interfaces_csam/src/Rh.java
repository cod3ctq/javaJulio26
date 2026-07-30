public class Rh extends Empleado implements IRecursosHumano{

    String numTelefo ;

    public Rh(){}

    public Rh(String rfc, String nombre, int aniosExp, String numeroEmepleado, String numTelefo) {
        super(rfc, nombre, aniosExp, numeroEmepleado);
        this.numTelefo = numTelefo;
    }

    public String getNumTelefo() {
        return numTelefo;
    }

    public void setNumTelefo(String numTelefo) {
        this.numTelefo = numTelefo;
    }

    @Override
    public String toString() {
        return "Rh{" +
                "numTelefo='" + numTelefo + '\'' +
                ", rfc='" + rfc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aniosExp=" + aniosExp +
                ", numeroEmepleado='" + numeroEmepleado + '\'' +
                '}';
    }

    @Override
    public void reclutar() {

    }

    @Override
    public void entrevistar() {

    }

    @Override
    public void gestionarExpediente() {

    }

    @Override
    public void capacitar() {

    }
    //MUTACIONES DE CLASES Implementacion de los metodos de
    //varias interfaces en una misma clase
}
