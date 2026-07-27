import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String lectura = "C:\\Users\\César\\Desktop\\autos.txt";
        String escritura="C:\\Users\\César\\Desktop\\escritura.txt";
        File file = new File(lectura); //Representacion del archivo en memoria
        File file2 = new File(escritura); //Representacion del archivo en memoria
        String linea; //aux
        String[] datos;

        try{
            FileReader fr = new FileReader(file); //Cache del contenido del archivo
            BufferedReader br = new BufferedReader(fr); //Lector del cache
            FileWriter fw = new FileWriter(file2);
            while( (linea=br.readLine()) !=null){ //Lectura del cache
                //System.out.println(linea);
                // 1- filtrar los del año 2020 o anteriores
                datos = linea.split("-");
//                if(Integer.parseInt(datos[2])<=2020){
//                    System.out.println(Arrays.toString(datos));
//                }
                // 2- filtrar todos los autos Azul de la marca Chevrolet
//                if(datos[0].equals("Chevrolet") && datos[5].equals("Azul")){
//                    System.out.println(Arrays.toString(datos));
//                }
                // 3- Filtrar todos los autos con un precio por encima de 400K
                // y que sean ESTANDAR, ademas
                //escribirlos en un nuevo archivo
                if(Integer.parseInt(datos[3])>400000 && datos[datos.length-1].equals("ESTANDAR")){
                    System.out.println(Arrays.toString(datos));
                    fw.write(linea+"\n");
                }
            }
            fw.close(); //cierra y guarda el flujo de datos en el archivo
        }catch(Exception ex){
            //ex.printStackTrace(); //Imprime la traza completa de la excepcion
            System.out.println(ex.getMessage()); //Imprime solo el mensaje de la excepcion
        }

    }
}