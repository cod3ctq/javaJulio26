import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String lectura ="C:\\Users\\Jafet\\Desktop\\autos.txt";
        String escritura = "C:\\Users\\Jafet\\Desktop\\escritura.txt";
        File file = new File(lectura); //Representación del archivo en memoria
        File file2 = new File(escritura); //Representación del archivo en memoria
        String linea; //aux
        String[] datos;

        try{
            FileReader fr = new FileReader(file); //Crear un caché de contenido del archivo
            BufferedReader br = new BufferedReader(fr); //Lector del caché
            FileWriter fw = new FileWriter(file2);

            while((linea=br.readLine()) !=null){ //Lectura del caché
                //System.out.println(linea);
                //1- filtrar los del año 2020 o anteriores
                datos = linea.split("-");

//                if(Integer.parseInt(datos[2])<=2020) {
//                    System.out.println(Arrays.toString(datos));
//                }

                //Filtrar todos los autos Azul de la marca Chevrolet
//                if(datos[0].equals("Chevrolet") && datos[5].equals("Azul")){
//                    System.out.println(Arrays.toString(datos));
//                }

                //3- Filtrar todos los autos por un precio por enciam de $400K y que sean estándar, además escribirlos
                //en un nuevo archivo
                if(Integer.parseInt(datos[3])>400000 && datos[datos.length-1].equals("ESTANDAR")){
                    System.out.println(linea);
                    fw.write(linea+"\n");
                }


            }
                fw.close(); //Cierra y guarda el flujo de datos en el archivo

        }catch (Exception ex){
            ex.printStackTrace(); //Imrpime la traza completa de la excepción
            System.out.println(ex.getMessage()); //Imprime solo el mensaje de la excepción
        }
    }
}



