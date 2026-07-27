import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[ ] args) {

//        //arrys o arreglo es una estrucutra del mismo tipo son estaticos
//        /// no puede crecer o reducirse el tiempo de ejeciccion
//
//
//        //DEclarar un arrys vacio
//         int [] datos = new int [15];
//
//         //imprimir los datos sin utilizar un iteracion
//        System.out.println(Arrays.toString(datos));
//
//        //imprime la direccion de memoria
//        System.out.println(datos);
//
//        //para ver un elemento de arrays debo de ser especifico
//        System.out.println(datos[3]);
//
//        //agregar datos al arrays manualmente
//        datos[0]=100;
//        datos[1]=120;
//        datos[3]=160;
//        datos[8]=500;
//
//        Scanner scan = new Scanner(System.in);
//        //cicloo para llenar un arrays automatico
//        for (int i =0 ;i<datos.length ;i++){
//            System.out.println("ingresa los datos: " + i);
//            datos[i]=scan.nextInt(); // se guarda por que es un entero;
//        }
//
//        //declarar un arrys lleno de inicios
//        int [ ] calificaciones = {10,10,10,7,6,5,6,54,3};
//        System.out.println("tamaño  : " + calificaciones.length);
//        calificaciones[1]=6;
//        System.out.println(Arrays.toString(calificaciones));
//
//
//        //crear una arrys que permita crear cualquier valor de tipo datos
//
//        Object[] variado = new Object[10];
//        variado[1]=300;
//        variado[2]="hola mundo";
//        variado[3]="java";
//        variado[4]=true;


        //iterar sobre este array
        //String[] valores = {"4","G","6","b","5","7","1","K","8","A","3","J","4","3","6",
              //  "7","2","B","A","R","9","6","1","w","Q","V","6","L","2","7"};

        //Filtrar : si el valor actual es un numero par, multiplicar por 5
        //          guardar el resultado en la misma posicion en el array de resultados
        //Filtrar : si el valor actual es un numero impar, dividir entre 3
        //          guardar el resultado en la misma posicion en el array de resultados
        //si es una letra, colocar un '@' en la misma posicion del array de resultados
        String[] valores = {"4","G","6","b","5","7","1","K","8","A","3","J","4","3","6",
                "7","2","B","A","R","9","6","1","w","Q","V","6","L","2","7"};

        String[] resultados = new String[valores.length];

        for (int i = 0; i < valores.length; i++) {

            if (Character.isDigit(valores[i].charAt(0))) {
                int numero = Integer.parseInt(valores[i]);

                if (numero % 2 == 0) {
                    resultados[i] = String.valueOf(numero * 5);
                } else {
                    resultados[i] = String.valueOf(numero / 3.0); // división decimal
                }

            } else {
                resultados[i] = "@";
            }
        }

// Mostrar resultados
        for (String resultado : resultados) {
            System.out.print(resultado + " ");
        }
    }
}