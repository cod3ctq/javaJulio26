import java.util.Arrays;
import java.util.Scanner;

public class Smartphone extends Celular{

    String sistemaOperativo;
    String[] aplicaciones;

    public Smartphone(){}

    /// ///////////////CONSTRUCTOR
    public Smartphone(String marca, String modelo, double precio, String sistemaOperativo, String[] aplicaciones) {
        super(marca, modelo, precio);
        this.sistemaOperativo = sistemaOperativo;
        this.aplicaciones = aplicaciones;
    }

    /// /////////////////////////////////////SETTER AND GETTER
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

    /// /////////////////////TOSTRING()
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

    //Método de la forma 2: heredado y sobreescrito

    @Override //Indica la sobreescritura
    public void llamar(String numero){
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Cómo deseas hacer la llamada?");
        System.out.println("1.- Red Operador");
        System.out.println("2.- WhatsApp");
        System.out.println("3.- Telegram");
        System.out.println("4.- Messenger");
        System.out.print("Selecciona una opción: ");
        int seleccion = sc.nextInt();

        switch (seleccion){
            case 1:
                System.out.println("\nLlamando al: "+numero+" por Red Operador.");
                break;
            case 2:
                System.out.println("\nLlamando al: "+numero+" por WhatsApp.");
                break;
            case 3:
                System.out.println("\nLlamando al: "+numero+" por Telegram.");
                break;
            case 4:
                System.out.println("\nLlamando al: "+numero+" por Messenger.");
                break;
            default:
                System.out.println("\nSelección no válida");
        }
    }

    public void mandarMensaje(String numero,String mensaje){
        System.out.println("Enviando:\n"+mensaje+" al número:\n"+numero);
    }

    //------POLIMORFISMO-------

    /*Sobrecarga vs Sobreescritura, y mutación de clases

    La sobrecarga actúa en los argumentos del método:
    Posibilidad de definir varios métodos con el mismo nombre pero distinta firma (cantidad y tipo de argumentos
    distinta)

    La sobreescritura es la redefinición de la lógica del método:
    Reemplazar los pasos ejecutados por el método originalmente por otros, logrando el mismo resultado.

    Mutación de clases: implementación de los métodos de varias interfaces en una misma clase.

     */

}
