public class Coche {

    String categoria;
    String motor;
    double consumo;
    String color;
    double capacidadCarga;
    int pasajeros;
    int puertas;
    double peso;
/*
tambien se pued considerar lo siguiente:
marca
modelo
año
precio

 */

    //contructor
    public Coche(){}

    public Coche(String categoria, String motor, double consumo, String color, double capacidadCarga, int pasajeros, int puestas, double peso) {
        this.categoria = categoria;
        this.motor = motor;
        this.consumo = consumo;
        this.color = color;
        this.capacidadCarga = capacidadCarga;
        this.pasajeros = pasajeros;
        this.puertas = puertas;
        this.peso = peso;
    }

    //getter and setter

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    //to.String()
    @Override
    public String toString() {
        return "Coche{" +
                "categoria='" + categoria + '\'' +
                ", motor='" + motor + '\'' +
                ", consumo='" + consumo + '\'' +
                ", color='" + color + '\'' +
                ", capacidadCarga=" + capacidadCarga +
                ", pasajeros=" + pasajeros +
                ", puertas=" + puertas +
                ", peso=" + peso +
                '}';
    }
}


