import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String lectura = "C:\\Users\\edtom\\Documents\\CETEQ\\archivos\\autos.txt";
        String escritura = "C:\\Users\\edtom\\Documents\\CETEQ\\archivos\\escritura.txt";

        File file = new File(lectura); //Representacion del archivo en memoria
        File file2 = new File(escritura);

        String linea; //Variable auxiliar
        String filtrado;

        String datos [];

        try {
            FileReader fr = new FileReader(file); //Crear un cache de contenido del archivo
            BufferedReader br = new BufferedReader(fr); //Leer el contenido del cache

            FileWriter fw = new FileWriter(file2);

            while((linea = br.readLine()) != null){ //Lectura del cache
                //System.out.println(linea);

                //1. Filtrar los del 2020 para abajo
                datos = linea.split("-");

                //System.out.println(Arrays.toString(datos));

                /*if(Integer.parseInt(datos[2])<=2020){
                    System.out.println(Arrays.toString(datos));
                }*/

                //2. <Fitrar todos los autos Azules de la marca Chevrolet

                /*if(datos[5].equals("Azul") && datos[0].equals("Chevrolet")){
                    System.out.println(Arrays.toString(datos));
                }*/

                // 3. Filtrar todos los autos con un precio arriba de los 400k
                // y que sean ESTANDAR, ademas
                // escribirlos en un nuevo archivo

                if ((Integer.parseInt(datos[3])>400000) && datos[6].equals("ESTANDAR")) {
                    System.out.println(linea);
                    fw.write(linea + "\n");
                }
            }
            fw.close(); // Cierra y guarda el flujo de datos en el archivo
        } catch (Exception ex) {
            //ex.printStackTrace(); //Imprime la traza completa de la excepcion
            System.out.println(ex.getMessage());
        }
    }
}