public class Celular {

    String marca;
    String modelo;
    double precio;

    public Celular(){}

    public Celular(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
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

    //COMO: comportamiento que se le atribuye al objeto
    //las acciones son metodos
    //las clases obtienen su comportamiento de 3 maneras
    /*
    1-metodos nativos
    2-metodos heredados (que comunmente se sobreescriben)
    3-metodos implementados (se requiere hacer uso de interfaces)
     */

    //acciones del objeto-se llama al metodo vacio
    //METODOS NATIVOS: acciones propias que le pertenecen al objeto
    public void llamar(String numero){
        System.out.println("Marcando al: "+numero);
    }
    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando: \n"+mensaje+" al numero: \n"+numero);
    }
}
