public class Celular {
    String marca;
    String modelo;
    double precio;

    public Celular(){

    }

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

//    metododos nativos
//             metodos hereados (comunente se socribien)
//                 metods implementados interfaces

    public void llamar(String numero){
        System.out.println("marcando al " + numero);
    }
    public void mandarmensaje(String numero , String mensaje){
        System.out.println("enviando  ;\n" + numero + "al numero : \n " + numero);
    }

}
