public class Pizza {

    String tamaño;
    String forma;
    int numIngredientes;
    double precio;

    public Pizza (){}

    public Pizza(String tamaño, String forma, int numIngredientes, double precio) {
        this.tamaño = tamaño;
        this.forma = forma;
        this.numIngredientes = numIngredientes;
        this.precio = precio;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public int getNumIngredientes() {
        return numIngredientes;
    }

    public void setNumIngredientes(int numIngredientes) {
        this.numIngredientes = numIngredientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "tamaño='" + tamaño + '\'' +
                ", forma='" + forma + '\'' +
                ", numIngredientes=" + numIngredientes +
                ", precio=" + precio +
                '}';
    }
}
