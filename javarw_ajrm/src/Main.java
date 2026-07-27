import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

     String lectura="C:\\Users\\jared\\OneDrive\\Escritorio\\autos.txt";
     String escritura="C:\\Users\\jared\\OneDrive\\Escritorio\\Escritura.txt";
     File file1 = new File(lectura); //Representacion del archivo en memoria
     File file2 = new File(escritura); //representacion del archivo en memoria
     String linea;
     String[] datos;
     String filtrado;




     try{
         FileReader fr = new FileReader(file1);
         BufferedReader br = new BufferedReader(fr);
         FileWriter fw = new FileWriter(file2);
         while ( (linea=br.readLine()) !=null){
//             System.out.println(linea);
             //1.Filtrar los autos del año 2020 o anteriores
             datos = linea.split("-");
//             if(Integer.parseInt(datos[2])<=2020){zl
//                 System.out.println(Arrays.toString(datos));
//             }

             //2.Filtrar todos los autos rojos de la marca Chevrolet
//             if(datos[0].equals("Chevrolet") && datos[5].equals("Azul")){
//                 System.out.println(datos);
//             }

             /*3.Filtrar todos los autos con un precio por encima de 400k
             y que sean estándar, ademas
             escribirlos en un nuevo archivo*/
             if (Integer.parseInt(datos[3])>400000 && datos[datos.length-1].equals("ESTANDAR")){
                 //System.out.println(Arrays.toString(datos));
                 System.out.println(linea);
                 fw.write(linea+"\n");
             }
         }
         fw.close();// Cierra y gurda el fluyo de datos en el archivo

     }catch (Exception ex){
        // ex.printStackTrace(); //Imprime la traza completa de la excepcion
         System.out.println(ex.getMessage()); //Imprime solo el mensaje de la excepcion
     }



    }
}