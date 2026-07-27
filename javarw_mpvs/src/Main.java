import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    String lectura= "C:\\Users\\Maria Paola\\OneDrive\\Desktop\\1_5134589636651256350.txt";
    String escritura = "C:\\Users\\Maria Paola\\OneDrive\\Desktop\\escritura.txt";
    File file = new File(lectura); //representacion del archivo en memoria
    File file2 = new File(escritura);
    String linea; // variable auxiliar
    String [] datos;

    try{
        FileReader fr = new FileReader(file); //crea un cache del contenido del archivo, copia de lectura en una memoria mas rapida ram
        BufferedReader br = new BufferedReader(fr); //Lector del cache
        FileWriter fw = new FileWriter(file2);

        while ((linea=br.readLine()) !=null){
            //System.out.println(linea);
            //filtrar los del año 2020 o anteriores
            datos = linea.split("-");
//            if (Integer.parseInt(datos[2])<=2020){
//                System.out.println(Arrays.toString(datos));
//            }
            //2. Filtrar todos los autos AZUL de la marca Chevrolet
//            if (datos[0].equals("Chevrolet") && datos[5].equals("Azul")){
//                System.out.println(Arrays.toString(datos));
//            }

            //3- Filtrar todos los autos con un precio por encima de 400k y que sen estandar
            // ademas escribirlo en un nuevo archivo
            if (Integer.parseInt(datos[3])>400000 && datos[datos.length-1].equals("ESTANDAR")){
                System.out.println(linea);
                fw.write(linea+ "\n");
            }
        }
        fw.close();//
    }catch (Exception ex){
        //ex.printStackTrace(); //imprime la traza completa de la excepcion
        System.out.println(ex.getMessage()); //imprime solo el mensaje del error
    }
    }
}