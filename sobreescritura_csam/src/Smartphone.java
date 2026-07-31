import java.util.Arrays;
import java.util.Scanner;

public class Smartphone extends Celular {
    String sistemaOperativo ;
    String [] aplicaciones;

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
    @Override //indica la sobre escritura
    public void llamar(String numero){
        Scanner sc = new Scanner(System.in);
        System.out.println("Como deseas hacer la llamada" );
        System.out.println("1 - red operador ");
        System.out.println("2 - Whatsapp ");
        System.out.println("3 - Telegram ");
        System.out.println("4 - Mesenger ");
        System.out.println("elige una opcion ");
        int seleccion =sc.nextInt();
        switch (seleccion){
            case 1:
                System.out.println("Llamando al : " + numero + " red de operador");
                break;
            case 2:
                System.out.println("Llamando al : " + numero + " Whatsasp");
                break;
            case 3:
                System.out.println("Llamando al : " + numero + " Telegram");
                break;
            case 4:
                System.out.println("Llamando al : " + numero + "Messenger");
                break;
            default:
                System.out.println("opcion no valida");
        }
    }
    public void mandarmensaje(String numero , String mensaje){
        System.out.println("enviando  ;\n" + numero + "al numero : \n " + numero);
    }

    //---POLIMOSFISMO---
    //sobrecarga sobreescritura
    //sobrecarga actua en los argumentos del metodo
    //posibilidad de definir varios metods con el mismo nombre
    //pero distinta firma (cantidad y tipos dde argumentos)

    //sobreescritura redefinicion de la logica del metodo
    //reeamplazar los pasos ejecutados por el metodo originalmete
    //pero llegando a mismo resultado


}
