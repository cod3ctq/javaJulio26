public class BoletoConcierto extends Boleto{

            //Si no se genera ningun constructor, Java otorga el constructor
            //vacio por default

            //Especializacion: Concrecion del modelo en alguno concepto mas especifico
            //esto se logra añadiendo mas atributos y/o metodos

            //Atributos propios de este modelo en participar
            String evento;
            String zona;
            String nombre;
            String empresa;



    public BoletoConcierto(){}
                public BoletoConcierto(String folio, String fecha, double precio, String evento, String zona, String nombre, String empresa) {
            super(folio, fecha, precio);
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
                ", folio='" + folio + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                '}';
    }
}
