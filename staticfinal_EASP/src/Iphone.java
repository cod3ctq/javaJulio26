import java.util.Arrays;

public class Iphone {
    //static: Permite crear miembros de clase
    //Que su valor y su contexto le pertenece a la clase en si misma
    //No dependen de la instancia

    //static + final = CONSTANTES, valores inmutables
    public static final String SISTEMA_OPERATIVO = "iOs";
    public static final String FABRICANTE = "Apple";

    //Miembros de instancia
    String modelo;
    String puertoCarga;
    int almacenamiento;
    String[] aplicaciones;
    int version;

    public Iphone(String modelo, String puertoCarga, int almacenamiento, String[] aplicaciones, int version) {
        this.modelo = modelo;
        this.puertoCarga = puertoCarga;
        this.almacenamiento = almacenamiento;
        this.aplicaciones = aplicaciones;
        this.version = version;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPuertoCarga() {
        return puertoCarga;
    }

    public void setPuertoCarga(String puertoCarga) {
        this.puertoCarga = puertoCarga;
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
                ", puertoCarga='" + puertoCarga + '\'' +
                ", almacenamiento=" + almacenamiento +
                ", aplicaciones=" + Arrays.toString(aplicaciones) +
                ", version=" + version +
                '}';
    }
}
