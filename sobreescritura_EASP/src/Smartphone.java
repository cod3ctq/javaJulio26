import java.util.Arrays;
import java.util.Scanner;

public class Smartphone extends Celular {

    String sistemaOperativo;
    String[] aplicaciones;

    public Smartphone(){}

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

    //Metodo de la forma 2: Heredado y sobreescrito.
    //Estamos sobreescribiendo el metodo "llamar" que hereda de la clase padre
    @Override //Es la señalizacion que indica la sobreescritura, o sea, no es el metodo original o nativo.
    public void llamar(String numero){
        Scanner sc = new Scanner(System.in);
        System.out.println("Como deseas hacer la llamada");
        System.out.println("1 - Red Operador");
        System.out.println("2 - Whatsapp");
        System.out.println("3 - Telegram");
        System.out.println("4 - Messenger");
        System.out.println("Selecciona una opcion");
        int seleccion = sc.nextInt();

        switch(seleccion){
            case 1:
                System.out.println("LLamando al: " +numero+ " por Red Operador");
                break;
            case 2:
                System.out.println("Llamando al: " +numero+ " por Whatsapp");
                break;
            case 3:
                System.out.println("Llamando al: " +numero+ " por Telegram");
                break;
            case 4:
                System.out.println("Llamando al: " +numero+ " por Messenger");
                break;
            default:
                System.out.println("Seleccion no valida");
        }
    }

    public void mandarMensaje (String numero, String mensaje){
        System.out.println("Enviando :\n" +mensaje+ " al numero: \n" +numero);
    }

    //---POLIMORFISMO---

    //Sobrecarga vs Sobreescritura
    //La SOBRECARGA actua en los argumentos del metodo:
    //Es la posibilidad de definir varios metodos con el mismo nombre pero distinta firma (cantidad y tipo de argumentos distinta)

    //La SOBREESCRITURA es la redefinicion de la logica del metodo:
    //Reemplazar los pasos ejecutados originalmente por otros, logrando el mismo resultado

    //Ambos son dos presentaciones del mismo concepto,junto a mutacion de clases, el POLIMORFISMO.

    //Mutacion de clases: Implementacion de los metodos de varias interfaces en una misma clase




}
