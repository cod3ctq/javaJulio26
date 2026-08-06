import java.util.Arrays;
import java.util.Scanner;

public class Smartphone extends Celular {

    String sistemaOperativo;
    String[] aplicaciones;

    public Smartphone() { }

    public Smartphone(String marca, String modelo, double precio, String sistemaOperativo, String[] aplicaciones) {
        super(marca, modelo, precio);
        this.sistemaOperativo = sistemaOperativo;
        this.aplicaciones = aplicaciones;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String[] getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(String[] aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", aplicaciones=" + Arrays.toString(aplicaciones) +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                '}';
    }
    //Metodo de la forma 2: Heredado y Sobreescrito
    @Override //Indica la sobreescritura
    public void llamar(String numero) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Como deseas hacer la llamada?" + "\n"+
                           "1.- Red Operador" + "\n" +
                           "2.- Whatsapp" + "\n" +
                           "3.- Telegram" + "\n" +
                           "4.- Messenger");
        int seleccion =  sc.nextInt();
        switch (seleccion) {
            case 1:
                System.out.println("Llamando al: " + numero + " por Red Operador");
                break;
            case 2:
                System.out.println("Llamando al: " + numero + " por Whatsapp");
                break;
            case 3:
                System.out.println("Llamando al: " + numero + " Telegram");
                break;
            case 4:
                System.out.println("Llamando al: " + numero + " por Messenger");
                break;
            default:
                System.out.println("Sleccion no valida");
        }

    }

    @Override
    public void mandarMensaje(String numero, String mensaje) {
        System.out.println("Enviando: " + "\n" + mensaje + "\n" + "al numero: " + "\n" + numero);
    }

    //-------POLIMORFISMO-------

    //Sobrecarga vs Sobreescritura

    //Sobrecarga: Actua en los argumentos del metodo:
    //posibilidad de definir varios metodos con el mismo nombre
    //pero distinta firma  (cantidad y tipo de argumentos distinta)

    //Sobreescritura: Redefinicion de la logica del metodo
    //reemplazar los pasos ejecutados por el metodo originalmente.
    //por otros, logrando el mismo resultado.

    //Mutación de clases: Implementacion de los metodos de varias interfaces en una misma clase

}
