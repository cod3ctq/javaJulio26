import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Project1 {
    public static void main(String[] args) {

        String lectura ="C:\\Users\\not_s\\Desktop\\autos.txt";
        String escritura="C:\\Users\\not_s\\Desktop\\escritura.txt";
        File file = new File(lectura);//representacion del archivo en memoria
        File file2 =new File(escritura);
        String linea;//aux
        String []datos;
        String filtrado;

        try{//permite manejar errores
            FileReader fr = new FileReader(file);//crea cache del contenido del archivo
            //busca el archivo en el DD y lo almacena en la memoria RAM
            BufferedReader br = new BufferedReader(fr);//lector del cache
            FileWriter fw= new FileWriter(file2);

            while ((linea=br.readLine())!= null){//se realiza la lectura del cache
//                System.out.println(linea);
                //filtrar los autos del año 2020 o anteriores
                datos=linea.split("-");//se integra la informacion dentro de un array
//                if (Integer.parseInt(datos[2])<=2020){
//                    System.out.println(Arrays.toString(datos));
//                }
                //filtrar todos los autos azul de marca chevrolet
//                if (datos[0].equals("Chevrolet")&& datos[5].equals("Azul")){
//                    System.out.println(Arrays.toString(datos));
//                }
                //filtrar todos los autos con un precio por encima de 400k
                //y que sea estandar, ademas escribirlos en un nuevo archivo
                if (Integer.parseInt(datos[3])>400000 && datos[datos.length-1].equals("ESTANDAR")){
                    fw.write(linea+"\n");//llena el nuevo archivo
                    System.out.println(linea);
                }
            }
            fw.close();//cierra y guarda el flujo de datos en el archivo
        }catch (Exception ex){
            //ex.printStackTrace();//Imprime el trazo completo de la excepcion
            System.out.println(ex.getMessage());//imprime solo el mensaje de la excepcion
        }
    }
}
