public class BoletoConcierto extends Boleto {

    //Si no se genera ningún constructor, Java otorga el constructor vacío por default

    //Especialización: concreción del modelo en algún concepto más específico. Esto se logra añadiendo más
    //atributos y/o métodos


    //Atributos propios de este modelo en particular
    String evento;
    String zona;
    String nombre;
    String empresa;

    public BoletoConcierto(){}

    /// //////////////////////////////////////////////CONSTRUCTOR
    public BoletoConcierto(String folio, String fecha, double precio, String evento, String zona, String nombre,
                           String empresa) {
        super(folio, fecha, precio);
        this.evento = evento;
        this.zona = zona;
        this.nombre = nombre;
        this.empresa = empresa;
    }

    /// /////////////////////////////////////GETTER & SETTER
    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /// ///////////////////////toSTRING()
    @Override
    public String toString() {
        return "BoletoConcierto{" +
                "evento='" + evento + '\'' +
                ", zona='" + zona + '\'' +
                ", nombre='" + nombre + '\'' +
                ", empresa='" + empresa + '\'' +
                ", folio='" + folio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}
