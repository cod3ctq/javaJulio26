import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Array o arreglo: es una estructura de datos del mismo tipo; son estaticos
        //no pueden crecer o reducirse en tiempo de ejecución, (tamaño fijo)
/*

        //declarar un array vacio
        int[] datos = new int[15];

        //imprimir/ ver valores de todas las posiciones del array sin interar

        System.out.println(Arrays.toString(datos)); //Arrays es la clarse Wrapper de array

        //imprime solo la dirección de memoria
        System.out.println(datos);

        //para ver un elemento del array debo ser especifico
        System.out.println(datos[3]);

        //agregar valores al array
        datos[0] = 100;
        datos[1] = 120;
        datos[2] = 160;
        datos[8] = 500;

        System.out.println(Arrays.toString(datos));

        //ciclo para llenar el array automaticamente
        Scanner scan = new Scanner(System.in);
        for (int i=0; i<datos.length;i++){
            System.out.println("ingresa un numero, posicion "+i);
            datos[i] = scan.nextInt();

        }
        // imprime todo en una sola linea
        System.out.println(Arrays.toString(datos));



        //declarar un array lleno desdel el inicio
        int[] calificaiones = {10,10,10,5,6,3,2,10,7};

        //Reemplaza el valor de una celda
        calificaiones[1] = 6;

        System.out.println(Arrays.toString(calificaiones));

        //los arrays no tienen un tipo de dato exclusivo:
        //puedes hacer arrays de cualquier tipo de dato, sea primitico u objeto

        String palabras[] = new String[10];

        palabras[0] = "uno";
        palabras[1] = "dos";
        palabras[2] = "tres";
        palabras[3] = "cuatro";
        palabras[4] = "cinco";


        // los arrays tienen un valor default que depende de su tipo de dato declarado
        double[] xx = new double[10];
        System.out.println(Arrays.toString(xx));

        //crear un array que permita agregarsele cualquier valor de cualquier tipo de dato
        Object[] variado = new Object[10];

        variado[0] = 300;
        variado[1] = "hola mundo";
        variado[2] = 2123.3;
        variado[3] = true;

        //la clase madre de todos los objetos en java
*/

        // iterar sobre array

        String[] valores = {"4", "G", "6", "b", "5", "7", "1", "K", "8", "A", "3", "J", "4", "3", "6",
                "7", "2", "B", "A", "R", "9", "6", "1", "w", "Q", "V", "6", "L", "2", "7"};

        //Filtrar : si el valor actual es un numero par, multiplicar por 5
        //          guardar el resultado en la misma posicion en el array de resultados
        //Filtrar : si el valor actual es un numero impar, dividir entre 3
        //          guardar el resultado en la misma posicion en el array de resultados
        //si es una letra, colocar un '@' en la misma posicion del array de resultados
        System.out.println("el array original es: ");
        System.out.println(Arrays.toString(valores));

        String numero = "1234567890";
        String[] resultado = new String[valores.length];

        for (int i = 0; i < valores.length; i++) {
            //filtro numeros
            if(numero.contains(valores[i])){
                int x = Integer.parseInt(valores[i]);
                double residuo = x%2;
                if (residuo !=0){
                    resultado[i] = String.valueOf(x/3);
                }else {
                    resultado[i] = String.valueOf(x*5);
                }
            }else {
                resultado[i]= "@";
            }


        }

        System.out.println("la cadena nueva es:");
        System.out.println(Arrays.toString(resultado));





        /* metodo 2
               for (int i = 0; i < valores.length; i++){

            if (valores[i].matches("\\d")) {
                    double numero = Integer.parseInt(valores[i]);

                    if (numero % 2 ==0){
                        valores[i] = String.valueOf(numero*5);
                    }else {
                        valores[i] = String.valueOf( numero/3);
                    }

            }else {
                valores[i] = "@";
            }

        }

        System.out.println("El array de reemplazo es:");
        System.out.println(Arrays.toString(valores));
*/




    }
}