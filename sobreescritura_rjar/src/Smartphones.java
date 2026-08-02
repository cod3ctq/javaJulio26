import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Scanner;

public class Smartphones  extends Celular {

    String sistemaOperativo;
    String [] aplicaciones;

    public Smartphones (){}

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
        return "Smartphones{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", aplicaciones=" + Arrays.toString(aplicaciones) +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                '}';
    }

    //--------POLIFORMISMO------
    //SOBRE CARGA VS SOBRE ESCRITURA
    /*
    SOBRE CARGA: Actuan los argumentos del metodo: posibilidad de definir varios metodos con el mismo nombre
    pero distinta firma (cantidad y tipo de argumentos distinta)
    SOBRE ESCRITURA: La redefinición de la logica del metodo: originalmente por otros, logrando el mismo resultado
    *de una manera diferente*
     */

    //HERENCIA:

    //METODO DE LA FOMA 2: HEREDADO Y SOBREESCRITURA
@Override //iNDICA LA SOBREESCRITURA
    public void llamar (String numero){
        Scanner sc =new Scanner(System.in);
        System.out.println("Como deseas hacer la llamada");
        System.out.println("1- Red Operador");
        System.out.println("2- Whatsapp");
        System.out.println("3- Telegram");
        System.out.println("4- Messenger");
        System.out.println("Selecciona una opcion");
        int seleccion= sc.nextInt();
        switch(seleccion){
            case 1:
                System.out.println("Llamando al:"+numero+"por Red Operador");
                break;
            case 2:
                System.out.println("Llamando al:"+numero+"por Whatsapp");
                break;
            case 3:
                System.out.println("Llamando al:"+numero+"por Telegram");
                break;
            case 4:
                System.out.println("Llamando al:"+numero+"por Messenger");
                break;
            default:
                System.out.println("Seleccion no valida");
        }

    }
    public void mandarMensaje (String numero, String mensaje){
        System.out.println("Enviando:\n" + mensaje + "al numero:\n" + numero);
    }



    public Smartphones(String marca, String modelo, double precio, String sistemaOperativo, String[] aplicaciones) {
        super(marca, modelo, precio);
        this.sistemaOperativo = sistemaOperativo;
        this.aplicaciones = aplicaciones;


    }
}
