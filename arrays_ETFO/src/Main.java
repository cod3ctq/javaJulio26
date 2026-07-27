import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Array o arreglo: Es una estrutura de datos del mismo tipo, son estaticos
        //(No pueden crecer o reducirse en tiempo de ejecucion)

        //Declarar un array vacio
        int [] datos = new int [15];
        //Imprimir/ver los valores de todas las posiciones del array sin interar
        //System.out.println(Arrays.toString(datos));
        //Imprime solo la direccion de memoria
        //System.out.println(datos);
        //Para ver un elemento del array debo ser muy especifico
        //System.out.println(datos[3]);

        //agregar valores al array
        /*datos[0] = 100;
        datos[1] = 120;
        datos[2] = 160;
        datos[8] = 500;

        System.out.println(Arrays.toString(datos))*/

        //Ciclo para llenar el array automaticamente
        /*for(int i=0; i<datos.length; i++){
            System.out.println("Ingresa un numero, posicion[" + i + "]" + ": ");
            datos[i] = sc.nextInt();
        }*/

        //Imprime todo en una sola linea
        //System.out.println(Arrays.toString(datos));

        //Declarar un array lleno desde el incicio
        int [] calificaciones = {10, 10, 10, 5, 6, 3, 2, 10, 7};

        calificaciones[1] = 6;
        //System.out.println(Arrays.toString(calificaciones));

        String [] palabras = new String [10];
        /*palabras[0] = "A";
        palabras[1] = "B";
        palabras[2] = "C";
        palabras[3] = "D";
        palabras[4] = "E";*/

        //Los arrays tienen un valor default que depende de su tipo de dato declarado

        //Crear un array que permita agregarsele cualquier valor de cualquier tipo de dato
        Object[] variado = new Object[10];

        //Iterar sobre el siguiente array
        String[] valores = {"4","G","6","b","5","7","1","K","8","A","3","J","4","3","6",
                "7","2","B","A","R","9","6","1","w","Q","V","6","L","2","7"};
        String [] resultados = new String [valores.length];
        String [] num = {"0","1","2","3","4","5","6","7","8","9"};
        //A, B, C, D, E, F, G, H, I, J, K, L, M, N, Ñ, O, P, Q, R, S, T, U, V, W, X, Y, Z
        String [] abc = {"A","B", "C","D","E","F","G","H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a","b", "c","d","e","f","g","h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int i = 0; i < valores.length; i++) {
            for(int k = 0; k<num.length; k++){
                if(num[k].contains(valores[i])){
                    //System.out.println(valores[i]);
                    if((Integer.parseInt(valores[i]) % 2) == 0){
                        resultados[i] = String.valueOf(Integer.parseInt(valores[i]) * 5);
                    }
                    else{
                        resultados[i] = String.valueOf(Double.parseDouble(valores[i]) / 3);
                    }
                }
            }
            for (int x = 0; x < abc.length; x++){
                if(valores[i].equals(abc[x])){
                    resultados[i] = "@";
                }
            }
        }
        System.out.println(Arrays.toString(resultados));
        //Filtrar : si el valor actual si es un numero par, multiplicar por 5
        //Filtrar : si el valor actual es impar, dividir entre 3
        //Si es una letra, colocar un '@' colocar en la misma posicion en el array de resultados
        //Guardar el resultado en la misma posicion pero en el array de resultados
    }
}