//QUE Y COMO

public  class Celular {

    String marca;
    String modelo;
    double precio;

    public Celular(){}

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

    @Override
    public String toString() {
        return "Celular{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                '}';



        }




    public Celular(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;


    }
    //COMO: Comportamiento que se le atribuye al objeto
    //Metodos o acciones

    //Las clases obtienen su comportamiento de 3 maneras:
        /*
        1. Metodos nativos
        2. Metodos heredados (comunes se sobreescriben)
        3. Metodos implementados (interfaces)
         */
//1 Metodos nativos: Acciones propias del conteto de este modelo
    public  void llamar (String numero){
        System.out.println("Marcando al :" + numero);
    }
    public void mandarMensaje (String numero, String mensaje){
        System.out.println("Enviando:\n" + mensaje + "al numero:\n" + numero);
    }
}
