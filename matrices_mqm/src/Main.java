import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //una matriz es un array completo lleno de arrays

        //crear matriz vacia
//        int[][] matriz1 = new int[4][5];
//
//        System.out.println(Arrays.deepToString(matriz1));//depptoString imprime la matriz completa
//
//        //llenarlo manualmente
//        matriz1[0][0] = 1;
//        matriz1[0][1] = 2;
//        matriz1[0][2] = 3;
//        matriz1[0][3] = 4;
//        matriz1[0][4] = 5;
//
//        matriz1[1][0] = 6;
//        matriz1[1][1] = 7;
//        matriz1[1][2] = 8;
//        matriz1[1][3] = 9;
//        matriz1[1][4] = 10;
//
//        matriz1[2][0] = 11;
//        matriz1[2][1] = 12;
//        matriz1[2][2] = 13;
//        matriz1[2][3] = 14;
//        matriz1[2][4] = 15;
//
//        matriz1[3][0] = 16;
//        matriz1[3][1] = 17;
//        matriz1[3][2] = 18;
//        matriz1[3][3] = 19;
//        matriz1[3][4] = 20;
//
//        System.out.println(Arrays.deepToString(matriz1));
//
//        //llenar la matriz desde teclado
//        for (int i=0;i<matriz1.length; i++){//itera entre las filas
//            //System.out.println(Arrays.toString(matriz1[i]));//imprime cada fila de la matriz
//            for (int c=0; c<matriz1[i].length;c++){//itera entre las columnas atraves de las filas
//                System.out.println("Fila: "+i+" columna: "+c+" valor: "+matriz1[i][c]);
//                //imprime el contenido de la matriz
//            }
//        }//ciclo anidado, lo que pasa dentro del for de c tambien afecta al ciclo del for de i
//
//        //crear matriz regular llena desde el inicio
//        String[][] m2 = {{"1","2","3"},{"4","5","6"}, {"7","8","9"}};
//
//        //crear matriz irregular llena desde el inicio
//        String [][] m3 = {{"1","2"}, {"4"}, {"7","8","9"}};


        String[][] cuadro1 = {{"a","2","c"},{"4","e","6"}};
        String [][] cuadro2 = {{"g","8","i"},{"10","k","12"}};
        String [][] cuadro3 =new String[2][3];

        String letras="abcdefghijkl";
        int numero1=0;
        char caracter1;

        for (int a=0; a<cuadro1.length;a++){
            for (int b = 0; b < cuadro1.length; b++) {

            }
        }



//        for (int c=0; c< cuadro2.length;c++){
//            for (int d= 0; d< cuadro2.length; d++) {
//                if (Character.isDigit(d)) {
//                    numero2=d;
//                }else{
//                    caracter2=d+"";
//                }
//            }
//        }
    }
}