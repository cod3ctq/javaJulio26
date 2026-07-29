public class BoletoConcierto extends Boleto {


    //Si no se genera ningun constructor, java otorga el constructor vacio por default
    //especializacion: concrecion del modelo en algun concepto mas especifico, esto se logra
    //añadiendo mas atributos y/o metodos
    //atrbutos propios de este modelo en particulas
    String evento;
    String zona;
    String nombre;
    String emresa;

    public BoletoConcierto (){}

    public BoletoConcierto(String folio, String fecha, double precio, String evento, String zona,
                           String nombre, String emresa) {
        super(folio, fecha, precio);
        this.evento = evento;
        this.zona = zona;
        this.nombre = nombre;
        this.emresa = emresa;
    }

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

    public String getEmresa() {
        return emresa;
    }

    public void setEmresa(String emresa) {
        this.emresa = emresa;
    }

    @Override
    public String toString() {
        return "BoletoConcierto{" +
                "evento='" + evento + '\'' +
                ", zona='" + zona + '\'' +
                ", nombre='" + nombre + '\'' +
                ", emresa='" + emresa + '\'' +
                ", folio='" + folio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}
