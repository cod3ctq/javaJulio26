/*
Las clase son los qué y como
 */

public class Celular {

    String marca;
    String modelo;
    double precio;

    public Celular(){};

    /// ///////////////////////CONSTRUCTOR
    public Celular(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    /// ////////////////////////////////GETTER AND SETTER
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /// ////////////////////////////////////TOSTRIING()
    @Override
    public String toString() {
        return "Celular{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                '}';
    }

    //COMO: Comportamiento que se le atribuye al objeto (Métodos o acciones)

    /*Las clases obtienen su comportamiento de 3 maneras:
    1- Métodos nativos
    2. Métodos heredados (comúnmente se sobreescriben)
    3. Métodos implementados (interfaces)
     */

    //1. Métodos nativos: Acciones propias del contexto de este modelo
    public void llamar(String numero){
        System.out.println("Marcando al: "+numero);
    }

    public void mandarMensaje(String numero,String mensaje){
        System.out.println("Enviando:\n"+mensaje+" al número:\n"+numero);
    }

}
