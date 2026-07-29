public class Auto {

    //Color,Marca,Modelo,Año,Precio,Cilindrada,Motor,Transmisión, Carrocería
    String color;
    String marca;
    String modelo;
    int año;
    double precio;
    double cilindrada;
    String motor;
    String transmision;
    String carroceria;

    public Auto(){} //Vacío

    //Constructor
    public Auto(String color, String marca, String modelo, int año, double precio, double cilindrada, String motor, String transmision, String carroceria) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.cilindrada = cilindrada;
        this.motor = motor;
        this.transmision = transmision;
        this.carroceria = carroceria;
    }

    //Getter and Setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    //toString()
    @Override
    public String toString() {
        return "Auto{" +
                "color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", precio=" + precio +
                ", cilindrada=" + cilindrada +
                ", motor='" + motor + '\'' +
                ", transmision='" + transmision + '\'' +
                ", carroceria='" + carroceria + '\'' +
                '}';
    }
}
