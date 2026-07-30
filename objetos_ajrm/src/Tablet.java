import java.util.Arrays;

//Clase: Modelo o plantilla conceptual,
        //que expresa un QUE y COMO
public class Tablet {

        double tamaño;
        String color;
        String forma;
        double peso;

        //Composicion: relcion donde un objeto se compone de otros mas pequeños
        String [] aplicaciones;
        Camara cam;

        double precio;
        String marca;
        int ram;
        String sistemaOpertivo;

        //Miembros por default
        //metodo constructor

        //Permite inicializar una instancia vacioa del objeto
        public Tablet(){} //vacio

            // Generarlo: clic derecho --> generate --> constructor / marcar todos / OK
            public Tablet(double tamaño, String color, String forma, double peso, double precio, String marca, int ram, String sistemaOpertivo) {
                this.tamaño = tamaño;
                this.color = color;
                this.forma = forma;
                this.peso = peso;
                this.precio = precio;
                this.marca = marca;
                this.ram = ram;
                this.sistemaOpertivo = sistemaOpertivo;
            }

            public Tablet(double tamaño, String color, String forma, double peso, String[] aplicaciones, Camara cam, double precio, String marca, int ram, String sistemaOpertivo) {
                this.tamaño = tamaño;
                this.color = color;
                this.forma = forma;
                this.peso = peso;
                this.aplicaciones = aplicaciones;
                this.cam = cam;
                this.precio = precio;
                this.marca = marca;
                this.ram = ram;
                this.sistemaOpertivo = sistemaOpertivo;
            }

            //Generarlo: clic derecho --> generate --> getter and setter / marcar todos / OK
            public double getTamaño() {
                return tamaño;
            }

            public void setTamaño(double tamaño) {
                this.tamaño = tamaño;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getForma() {
                return forma;
            }

            public void setForma(String forma) {
                this.forma = forma;
            }

            public double getPeso() {
                return peso;
            }

            public void setPeso(double peso) {
                this.peso = peso;
            }

            public double getPrecio() {
                return precio;
            }

            public void setPrecio(double precio) {
                this.precio = precio;
            }

            public String getMarca() {
                return marca;
            }

            public void setMarca(String marca) {
                this.marca = marca;
            }

            public int getRam() {
                return ram;
            }

            public void setRam(int ram) {
                this.ram = ram;
            }

            public String getSistemaOpertivo() {
                return sistemaOpertivo;
            }

            public void setSistemaOpertivo(String sistemaOpertivo) {
                this.sistemaOpertivo = sistemaOpertivo;
            }

    public String[] getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(String[] aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    public Camara getCam() {
        return cam;
    }

    public void setCam(Camara cam) {
        this.cam = cam;
    }


    //Generarlo: clic derecho --> Generate --> toString() / OK

    @Override
    public String toString() {
        return "Tablet{" +
                "tamaño=" + tamaño +
                ", color='" + color + '\'' +
                ", forma='" + forma + '\'' +
                ", peso=" + peso +
                ", aplicaciones=" + Arrays.toString(aplicaciones) +
                ", cam=" + cam +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", ram=" + ram +
                ", sistemaOpertivo='" + sistemaOpertivo + '\'' +
                '}';
    }
}
