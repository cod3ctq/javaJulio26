public class Videogames {
    String nombre;
    String fechaLanzamiento;
    String descripcion;
    double peso;
    String plataformas;
    String desarroladora;
    String genero;
    String clasificacion;
    String idioma;
    String motorGrafico;

    public Videogames () { }

    public Videogames (
            String nombre, String fechaLanzamiento, String descripcion,
            double peso, String plataformas, String desarroladora,
            String genero, String clasificacion, String idioma,
            String motorGrafico
    ) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.descripcion = descripcion;
        this.peso = peso;
        this.plataformas = plataformas;
        this.desarroladora = desarroladora;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.idioma = idioma;
        this.motorGrafico = motorGrafico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(String plataformas) {
        this.plataformas = plataformas;
    }

    public String getDesarroladora() {
        return desarroladora;
    }

    public void setDesarroladora(String desarroladora) {
        this.desarroladora = desarroladora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getMotorGrafico() {
        return motorGrafico;
    }

    public void setMotorGrafico(String motorGrafico) {
        this.motorGrafico = motorGrafico;
    }

    @Override
    public String toString() {
        return "Videogames{" +
                "nombre='" + nombre + '\'' +
                ", fechaLanzamiento='" + fechaLanzamiento + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", peso=" + peso +
                ", plataformas='" + plataformas + '\'' +
                ", desarroladora='" + desarroladora + '\'' +
                ", genero='" + genero + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", idioma='" + idioma + '\'' +
                ", motorGrafico='" + motorGrafico + '\'' +
                '}';
    }
}
