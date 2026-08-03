public class Auto {

    private String modelo;
    private String color;
    private double precio;
    private int anio;
    private String transmision;
    private String vin;

    public Auto(){}

    public Auto(String modelo, String color, double precio, int anio, String transmision, String vin) {
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.anio = anio;
        this.transmision = transmision;
        this.vin = vin;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", anio=" + anio +
                ", transmision='" + transmision + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
