import java.util.Arrays;

public class Iphone {

    //static: Permite crear miembros de clase que su valor y contexto le pertenece a la clase en si misma
    //no dependen de la instancia
    //Una constante siempre debe estar en mayusculas
    //static + final = CONSTANTES, valores inmutables
    public static final String SISTEMA_OPERATIVO = "iOS";
    public static final String FABRICANTE = "Apple";

    //Miembros de instancia
    String modelo;
    String puerto;
    int almacimiento;
    String[] aplicaciones;
    int version;

    public Iphone(String modelo, String puerto, int almacimiento, String[] aplicaciones, int version) {
        this.modelo = modelo;
        this.puerto = puerto;
        this.almacimiento = almacimiento;
        this.aplicaciones = aplicaciones;
        this.version = version;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public int getAlmacimiento() {
        return almacimiento;
    }

    public void setAlmacimiento(int almacimiento) {
        this.almacimiento = almacimiento;
    }

    public String[] getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(String[] aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Iphone{" +
                "modelo='" + modelo + '\'' +
                ", puerto='" + puerto + '\'' +
                ", almacimiento=" + almacimiento +
                ", aplicaciones=" + Arrays.toString(aplicaciones) +
                ", version=" + version +
                '}';
    }
}
