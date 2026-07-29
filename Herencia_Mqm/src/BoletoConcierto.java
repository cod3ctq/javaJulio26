public class BoletoConcierto extends Boleto {

    //si no se genera ningun constructor, java otorga el constructor
    //vacio por default
    //con la palabra extends + nombre de la clase padre,
    // se hereda toda la informacion de la clase padre

    //atributos propios de este modelo
    String evento;
    String zona;
    String nombre;
    String empresa;

    //Especializacion: concrecion del modelo en algun concepto
    //mas especifico, esto se logra añadiendo mas atributos y/o metodos

    //al agregar su 1er constructor solo se selecciona el llamado boletoConcierto,
    // en los demas constructores se selccionan igual


    public BoletoConcierto(String folio, String fecha, double precio, String evento, String zona, String nombre, String empresa) {
        super(folio, fecha, precio);
        this.evento = evento;
        this.zona = zona;
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public BoletoConcierto() {}

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
