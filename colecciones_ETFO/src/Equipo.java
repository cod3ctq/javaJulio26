public class Equipo {
    private String marca;
    private String modelo;
    private String color;
    private String compania;
    private String modalidad;
    private double precio;

    public Equipo() { }

    public Equipo(String marca, String modelo, String color, String compania, String modalidad, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.compania = compania;
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

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", compania='" + compania + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", precio=" + precio +
                '}';
    }
}
