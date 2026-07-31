import java.util.Arrays;

public class Iphone {
//static: Permite crear miembros de clase
    //Que su valor y su contexto le pertenece a la clase en si misma
    //no dependen de la instancia

    //static+final=CONSTANTES, valores inmutable (no se pueden asignar)
    public static final String SISTEMA_OPERATIVO="iOs";
    public static final String FABRICANTE="Apple";

    //Miembros de instancia
    String modelo;
    String puerto;
    int almacenamiento;
    String [] aplicaciones;
    int version;



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

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
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
                ", almacenamiento=" + almacenamiento +
                ", aplicaciones=" + Arrays.toString(aplicaciones) +
                ", version=" + version +
                '}';
    }

    public Iphone(String modelo, String puerto, int almacenamiento, String[] aplicaciones, int version) {
        this.modelo = modelo;
        this.puerto = puerto;
        this.almacenamiento = almacenamiento;
        this.aplicaciones = aplicaciones;
        this.version = version;


    }
}
