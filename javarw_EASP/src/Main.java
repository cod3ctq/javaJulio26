import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String lectura="C:\\Users\\cacho\\Desktop\\autos.txt"; //Es la ubicacion como linea de texto
        String escritura="C:\\Users\\cacho\\Desktop\\Escritura.txt";
        File file= new File(lectura); //Representacion del archivo en memoria (en forma de objeto en java)
        File file2= new File(escritura);
        String linea; //aux
        String[] datos;

        try{
            FileReader fr= new FileReader(file); //Crea un Cache del contenido del archivo
            BufferedReader br= new BufferedReader(fr); //Lector del cache

            FileWriter fw= new FileWriter(file2);

            while ((linea= br.readLine()) !=null){ //Lectura del cache
                //System.out.println(linea);


                datos=linea.split("-");

                //Filtrar los del año 2020 o anteriores
//                if (Integer.parseInt(datos[2])<=2020){
//                    System.out.println(Arrays.toString(datos));
//                }

                //Filtrar los autos Rojos de la marca Chevrolet
//                if (datos[5].equals("Azul") && datos[0].equals("Chevrolet")){
//                    System.out.println(Arrays.toString(datos));
//                }

                //Filtrar tdos los autos con un precio por encima de 400K
                //Y que sean estandar, además
                //Escribirlos en un nuevo archivo

                if (Integer.parseInt(datos[3])>400000 && datos[datos.length-1].equals("ESTANDAR")){
                    System.out.println(linea);
                    fw.write(linea+"\n"); //"\n" para salto de linea.
                }
            }
            fw.close(); //Cierra y guarda el flujo de datos en el archivo.

        }catch (Exception ex){
            ex.printStackTrace(); //Imprime la traza completa de la excepcion
            System.out.println(ex.getMessage()); //Imprime el puro mensaje de la excepcion, no es necesario usar ambos
        }








    }
}