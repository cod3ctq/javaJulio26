import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //

//        //Declarar un array vacio
//        int[] datos = new int[15];
//
//        //Imprimir / Ver los valores de todas las pocisiones del array sin interar
//        System.out.println(Arrays.toString(datos));
//
//        //Imprime solamente la direccion de memoria
//        System.out.println(datos);
//
//        //Para ver un elemento del array debo ser especifico
//        System.out.println(datos[3]);
//
//        //Agregar valores manualmente del array
//        datos[0] = 100;
//        datos[1] = 120;
//        datos[2] = 160;
//        datos[8] = 500;
//
//        System.out.println(Arrays.toString(datos));
//
//        //Ciclo para llenar el array automaticamente
////        Scanner scan = new Scanner(System.in);
////        for (int i = 0; i < datos.length; i++){
////
////            System.out.println("Ingresa un numero, posición: " + i);
////            datos[i] = scan.nextInt();
//        }

        //Imprime todo en una sola linea
//        System.out.println(Arrays.toString(datos));

        //Declarar un array lleno desde el inicio
//        int[] calificaciones = {10,10,10,5,6,3,2,10,7};
//        System.out.println("Tamaño : "+calificaciones.length);
//
//        //Reemplaza el valor de una celda
//        calificaciones[1]=6;
//
//        System.out.println(Arrays.toString(calificaciones));
//
//        //Los arrays no tienen un tipo de dato exclusivo:
//        //Puedes hacer arrays de cualquier tipo de dato, sea primitivo u objeto
//        String [] palabras = new String[10];
//        palabras[0] = "uno";
//        palabras[1] = "dos";
//        palabras[2] = "tres";
//        palabras[3] = "cuatro";
//        palabras[4] = "cinco";
//
//        //Los arrays tienen un valor default que dependa de su tipo de dato declarado
//        String[] xx = new String[10];
//        System.out.println(Arrays.toString(xx));
//
//        //Crear un array que permita agregarsele cualquier valor de cualquier tipo de dato
//        Object[] variado = new Object[10];
//
//        variado[0] = 300;
//        variado[1] = "Hola mundo";
//        variado[2] = 2123.3;
//        variado[3] = true;
//
//        System.out.println(Arrays.toString(variado));

        //Iterar sobre este array
            String[] valores = {"4","G","6","b","5","7","1","K","8","A","3","J","4","3","6",
                "7","2","B","A","R","9","6","1","w","Q","V","6","L","2","7"};

        //Filtrar : si el valor actual es un numero par, multiplicar por 5,
        //          guardar el resultado en la misma posicion pero en el array de resultados

        //Filtrar : si el valor actual es un numero impar, dividir entre 3,
        //          guardar el resultado en la misma posicion pero en el array de resultados

        //Filtrar : si es una letra colocar una @ en la misma posicion del array de resultados


            System.out.println(Arrays.toString(valores));
    }
}