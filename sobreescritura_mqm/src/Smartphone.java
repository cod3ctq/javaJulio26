import java.util.Arrays;
import java.util.Scanner;

public class Smartphone extends Celular{

    String sistemaOperativo;
    String[]aplicaciones;

    public Smartphone (){}

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

    //METODO 2: Heredado y sobreescrito
    @Override//indica la sobreescritura
    public void llamar(String numero){
        Scanner sc =new Scanner(System.in);
        System.out.println("Como deseas hacer la llamada");
        System.out.println("1 - Red Operador");
        System.out.println("2 - Whatsapp");
        System.out.println("3 - Telegram");
        System.out.println("4 - Messenger");
        int seleccion = sc.nextInt();
        switch (seleccion){
            case 1:
                System.out.println("Llamando al: "+numero+" por Red Operador");
                break;
            case 2:
                System.out.println("Llamando al: "+numero+" por Whatsapp");
                break;
            case 3:
                System.out.println("Llamando al: "+numero+" por Telegram");
                break;
            case 4:
                System.out.println("Llamando al: "+numero+" por Messenger");
                break;
            default:
                System.out.println("Seleccion no valida");
        }
    }
    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando: \n"+mensaje+" al numero: \n"+numero);
    }

    //sobrecarga vs sobreescritura
    //sobrecarga actua en os argumentos del metodo:
    //posibilidad de definir varios metodos con el mismo nombre
    //pero distinta firma (cantidad y tipo de argumentos distinta)

    //sobreescritura redefinicion de la logica del metodo
    //reemplazar los pasos ejecutados por el metodo originalmente
    //por otros pasos logrando el mismo resultado

    //estos 2 metodos son presentaciones de 1 mismo concepto
    //--POLIMORFISMO--





}
