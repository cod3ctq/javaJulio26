public class Equipo {

        private String marca;
        private String modelo;
        private String color;
        private String compañia;
        private String modalidad;
        private Double precio;

        public Equipo(){
        }

    public Equipo(String marca, String modelo, String color, String compañia, String modalidad, Double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.compañia = compañia;
        this.modalidad = modalidad;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", compañia='" + compañia + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", precio=" + precio +
                '}';
    }
}
