public class BoletoConcierto  extends Boleto{
    //sino se genera un constructor vacio java
    //otorga un constructor vacio

    //atributos  concretacion mas especifico
    //esto se logra mas  añadiendto atributos y metodos

    //atributos  propios de este modelo
    String evento;
    String zona;
    String nombre;
    String empresa;

    public BoletoConcierto(){

    }
    public BoletoConcierto( String folio, String fecha, double precio ,String evento, String zona, String nombre, String empresa) {
        this.evento = evento;
        this.zona = zona;
        this.nombre = nombre;
        this.empresa = empresa;
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
                '}';
    }
}
