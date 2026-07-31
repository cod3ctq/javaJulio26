import java.util.Arrays;
import java.util.Scanner;

public class Smartphone extends Celular{

    String sistemaOperativo;
    String[] aplicaciones;

    public Smartphone(){}

    //1- Metodos nativos: Acciones propoas del contexto de este modelo:

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

    // metodo forma 2: heredado y sobreescrito
    @Override // Indica la sobreescritura
    public void llamar(String numero){
        Scanner sc = new Scanner(System.in);
        System.out.println("Como deseas hacer la llamada: ");
        System.out.println("1 - Red Operador");
        System.out.println("2 - Whatsapp");
        System.out.println("3 - Telegram");
        System.out.println("4 - Messenger");
        System.out.println("Selecciona una opción");
        int seleccion = sc.nextInt();

        switch (seleccion){

            case 1:
            System.out.println("llamando al :"+numero+" por Red operador");
                break;
            case 2:
                System.out.println("llamando al :"+numero+" por Whatsapp");
                break;
            case 3:
                System.out.println("llamando al :"+numero+" por Telegram");
                break;
            case 4:
                System.out.println("llamando al :"+numero+" por Messenger");
                break;
            default:
                System.out.println("Selección no valida");
        }



        //-----POLIMORFISMO-------
/*Sobre carga contra sobreescritura:

* *La sobre carga actua sobre los argumentos del metodo:
    Es la posibilidad de describir varios metodos con el mismo
    nombre pero distinta firma ( cantidad y tipo de argumentos distinta)

* *la sobre escritura es la redefinicion de la logica del metodo
    Reemplazar los pasos ejecutados ejecutados por el metodo original
    por otros, logrando el mismo resultado
 */



        // Mutación de clases: implementación de los metodos de
        //varias interfaces en una misma clase




    }

    public void  mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando : \n"+mensaje+"\nal numero: \n"+numero);
    }
}
