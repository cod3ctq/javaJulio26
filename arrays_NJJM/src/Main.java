import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*
        Array o arreglo: Es una estructura de datos del mismo tipo, son estáticos (No pueden crecer o reducirse en
        tiempo de ejecución).
         */

        //Declarar un array vacío
        int[] datos = new int[15];

        //Imprimir o ver los valores de todas la posiciones del array sin interar
        System.out.println(Arrays.toString(datos));

        //Imprime solamente la dirección de memoria
        System.out.println(datos);

        //Para ver un elemento del array debor ser específico
        System.out.println(datos[3]);

        //Agregar valores manualmente al array
        datos[0] = 100;
        datos[1] = 120;
        datos[2] = 160;
        datos[8] = 500;
        System.out.println(Arrays.toString(datos));

        //Ciclo para llenar el array automáticamente
//        Scanner entrada = new Scanner(System.in);
//        for(int i=0;i<datos.length;i++){
//            System.out.println("Ingresa un núumero, posición: "+i);
//            datos[i] = entrada.nextInt();
//        }

        //Imprimir todo en una sola línea
        System.out.println(Arrays.toString(datos));

        //Declarar un array lleno desde el inicio
        int[] calificaciones = {10,10,10,5,6,3,2,10,7};
        System.out.println("Tamaño: "+calificaciones.length);

        //Reemplazar el valor de una celda
        calificaciones[1] = 6;

        System.out.println(Arrays.toString(calificaciones));

        /*
        Los arrays no tienen un tipo de dato exclusivo:
        Puedes hacer arrays de cualquier tipo de dato, sea primitivo u objeto
         */

        //Los arryas tienen un valor default que depende de su tipo de dato declarado
        char[] xx = new char[10];

        System.out.println(Arrays.toString(xx));

        //Crear un array que permita agregársele cualquier valor de cualquier tipo de dato
        Object[] variado = new Object[10];

        variado[0] = 300;
        variado[1] = "Hola Mundo";
        variado[2] = 32.3;
        variado[3] = true;

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7

        /*
        Iterar sobre este array
        Filtrar:    si el valor actual es número par, multiplicar por 5
                    Guardar el resultado en la misma posición en el array de resultados
        Filtrar:    si el valor actual es número impar, dividir entre 3
                    Guardar el resultado en la misma posición en el array de resultados
        Filtrar:    si es una letra, colocar un '@' en la misma posición del array de resultados
         */
        String[] valores = {"4","G","6","b","5","7","1","K","8","A","3","J","4","3","6",
                "7","2","B","A","R","9","6","1","w","Q","V","6","L","2","7"};
        String[] resultados = new String[valores.length];
        float numero;

        System.out.println("EJERCICIO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        for(int i=0;i<valores.length;i++){

            if(Character.isDigit(valores[i].charAt(0))){ //Identificar si el caracter es un número o no
                //numero = Character.getNumericValue(valores[i].charAt(0)); //Convertir el caracter a un número
                numero = Float.parseFloat(valores[i]);
                if(numero%2 == 0){ //si el número es par
                    numero = numero * 5f;
                    resultados[i] = Float.toString(numero);
                }else{//Si el número es impar
                    numero = numero / 3f;
                    resultados[i] = Float.toString(numero);
                }
            }else{
                resultados[i] = "@";
            }
        }

        System.out.println("\nArray Inicial: ");
        System.out.println(Arrays.toString(valores));
        System.out.println("\nArray Resultado: ");
        System.out.println(Arrays.toString(resultados));

    }
}