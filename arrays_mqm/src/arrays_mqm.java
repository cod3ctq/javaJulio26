import java.util.Arrays;
import java.util.Scanner;

public class arrays_mqm {
    public static void main(String[] args) {

        //Array o arreglo: es una estructura de datos del mismo tipo, son estaticos
        //no pueden crecer o reducirse en tiempo de ejecucion

        //declarar un  array vacio
//        int[] datos = new int[15];
//
//        //Imprimir/ver los valores de todas las posiciones del array sin iterar
//        System.out.println(Arrays.toString(datos));
//
//        System.out.println(datos);//impresion de la direccion de memoria del array
//
//        System.out.println(datos[3]);//se debe especificar el elemento que se quiere ver
//        //sin salir de los limites dentro del array
//        //System.out.println(datos[10]);
//
//        //agregar valores manualmente al array
//        datos[0]=100;
//        datos[1]=120;
//        datos[2]=160;
//        datos[8]=500;

        //System.out.println(Arrays.toString(datos));

        //para llenar los arrays mas grnades se utilizan los ciclos
        //ciclo para llenar el array automaticamente

//        Scanner scan = new Scanner(System.in);
//        for (int i=0; i<datos.length; i++){
//            System.out.println("Ingresa un numero, posicion: "+i);
//            datos[i] =scan.nextInt();
//        }
//        //imprime todo en una sola linea
//        System.out.println(Arrays.toString(datos));

        //declarar un array lleno desde el inicio
        //utilizar llaves delimitan tambien el tamaño del array
        //segun la cantidad de valores que se le asignen

//        int[] calificaciones = {10,10,10,5,6,3,2,10,7};
//        System.out.println("Tamaño: "+calificaciones.length);
//
//        //Reemplazar el valor de una celda
//        calificaciones[1]=200;
//        System.out.println(Arrays.toString(calificaciones));
//
//        //los arrays no tienen un tipo de dato exclusivo
//        //puedes hacer arrays de cualquier tipo de dato, sea primitivo u objeto
//        String[] palabras = new String[10];
//        palabras[0]="uno";
//        palabras[1]="dos";
//        palabras[2]="tres";
//        palabras[3]="cuatro";
//
//        //los arrays tienen un valor default que dependen de su tipo de dato declarado
//        //siempre es cero, solo cambia su tipo de dato
//        double [] xx = new double[10];
//        System.out.println(Arrays.toString(xx));
//
//        byte [] b = new byte[10];
//        System.out.println(Arrays.toString(b));
//
//        float [] f = new float[10];
//        System.out.println(Arrays.toString(f));
//
//        String [] s = new String[10];
//        System.out.println(Arrays.toString(s));
//
//        boolean [] tf = new boolean[10];
//        System.out.println(Arrays.toString(tf));
//
//        Integer [] Int = new Integer[10];
//        System.out.println(Arrays.toString(Int));
//
//        //crear un array que permita agregarsele cualquier valor de cualquir tipo de dato
//        Object [] variado = new Object[10];
//
//        variado[0]=300;
//        variado[1]="hola mundo";
//        variado[2]=2123.35;
//        variado[3]=true;

        //iterar sobre el array
        //filtrar: si el valor actual es un numero par, multiplicar por 5
        //guardar el resultado en la misma posicion en el array de resultados
        //filtrar: si el valor actual es un numero impar, dividr entre 3
        //si es una letra colocar un '@' en la misma posicion del array de resultados

        String[] valores = {"4","G","6","b","5","7","1","K","8","A","3","J","4","3","6",
                "7","2","B","A","R","9","6","1","w","Q","V","6","L","2","7"};

        String [] resultados = new String[valores.length];

        //for (int i=0; i< valores.length; i++){
        //            int x = Character.getNumericValue(i);
//        int numero = x%2;
//
//            if (numero!=0) {
//                System.out.println("No es numero");
//            }
//            else if (numero==0) {
//                int par = x * 5;
//                System.out.println("Es par: " + x + " por 5 = " + par);
//            }

        String numeros="0123456789";

        for (int i=0; i< valores.length; i++){//i solo esta llamando al apuntador
            //filtrar numeros
            if (numeros.contains(valores[i])){//se evalua si dentro de valores existe
                // la variable numeros
                int x = Integer.parseInt(valores[i]);//convierte el valor obtenido en un entero
                int residuo = x%2;//operacion, validacion numerica encontrar el par e impar
                if (residuo!=0){
                    resultados[i] = String.valueOf(x / 3);//string.valueof convierte
                    //el entero a string
                }else {
                    resultados[i]=String.valueOf(x*5);
                }
            }else {
                resultados[i]="@";//se asigna directamente el valor al array despues de recorrer
                // el codigo
            }
        }
        System.out.println(Arrays.toString(resultados));
    }

    }


