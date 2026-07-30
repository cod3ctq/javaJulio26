public class Empleado {

    String rfc;
    String nombre;
    int añosExp;
    String numEmpleado;

    public Empleado() {
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

    public int getAñosExp() {
        return añosExp;
    }

    public void setAñosExp(int añosExp) {
        this.añosExp = añosExp;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "rfc='" + rfc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", añosExp=" + añosExp +
                ", numEmpleado='" + numEmpleado + '\'' +
                '}';
    }

void empleado (){}

    public Empleado(String rfc, String nombre, int añosExp, String numEmpleado) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.añosExp = añosExp;
        this.numEmpleado = numEmpleado;

    }



}




