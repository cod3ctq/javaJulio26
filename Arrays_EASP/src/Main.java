import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Un array o arreglo Es una estructura de datos del mismo tipo, son estaticos
        //(No pueden crecer o reducirse en tiempo de ejecucion, o sea, tienen un tamaño fijo)

        //Declarar un array vacio
        int[] datos = new int[15];

        //Imprimir o ver los valores de todas las posiciones del array sin iterar
        System.out.println(Arrays.toString(datos));

        //Imprime la direccion de memoria
        System.out.println(datos);

        //Para ver un elemento del array debo ser especifico, evitando salirse del rango
        System.out.println(datos[3]);

        //Agregar valores manualmente al array, no es necesario llenarse en orden
        datos[0] = 100;
        datos[1] = 120;
        datos[2] = 160;
        datos[8] = 500;

        System.out.println(Arrays.toString(datos));

        //ciclo para llenar el array automaticamente
        Scanner scan = new Scanner(System.in);
//        for(int i=0; i<datos.length; i++){
//            System.out.println("Ingresa un número, posicion: "+i);
//            datos[i] = scan.nextInt();
//        }
        System.out.println();
        System.out.println(Arrays.toString(datos));
        System.out.println();

        //Declarar un array lleno desde el inicio
        int[] calificaciones = {10, 10, 10, 5, 6, 3, 2, 10, 7};
        System.out.println(Arrays.toString(calificaciones));
        System.out.println("Tamaño: " +calificaciones.length);

        //Se puede reemplazar el valor de una celda
        calificaciones[1] = 6;
        System.out.println(Arrays.toString(calificaciones));

        //Los arrays no tienen un tipo de dato exclusivo,
        //Esto significa que puedes hacer array de cualquier tipo de dato, sea primitivo u objeto

        //Los arrays tienen un valor default que depende de su tipo de dato declarado
        //Todos los objetos tienen valor default "null", a diferencia que los primitivos que tienen un valor default definido
        System.out.println();
        double[] xx = new double[10];
        System.out.println(Arrays.toString(xx));

        String[] yy = new String[10];
        System.out.println(Arrays.toString(yy));

        Integer[] zz = new Integer[10];
        System.out.println(Arrays.toString(zz));

        //Crear un array que permita agregarsele cualquier valor de cualquier tipo de dato
        System.out.println();
        Object[] variado = new Object[10];

        variado[0] = 300;
        variado[1] = "hola mundo";
        variado[2] = 0.4534;
        variado[3] = true;
        variado[4] = '%';

        System.out.println(Arrays.toString(variado));








    }
}