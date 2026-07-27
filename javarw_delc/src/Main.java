import java.io.*;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String escritura = "C:\\Users\\danye\\Desktop\\escritura.txt";
        String lectura="C:\\Users\\danye\\Desktop\\autos.txt";

        File file = new File(lectura); // representacion dell archivo en memoria
        File file2 = new File(escritura);

        String linea; //variable aux
        String[] datos;


        try {
            FileReader fr = new FileReader(file); // cache del contenido del archivo
            BufferedReader br = new BufferedReader(fr); //lector del cache
            FileWriter fw = new FileWriter(file2);



            while ((linea = br.readLine()) != null) { //lectura del cache
                //System.out.println(linea);

                //filtar los autos del año 2020 o anteriores

                datos = linea.split("-");

              /*  if (Integer.parseInt(datos[2]) <= 2020){
                    System.out.println(Arrays.toString(datos));
                }*/

               /* //filtrar los autos azul de la marca Chevrolet
                if (datos[0].equals("Chevrolet") && datos[5].equals("Azul")){
                    System.out.println(Arrays.toString(datos));
                }*/

                //filtrar autos con un precio por arriba de $400k
                //que sean ESTANDAR, escribirlos en un nuevo archivo

                if (Integer.parseInt(datos[3])>400000 && datos[datos.length-1].equals("ESTANDAR")){
                    System.out.println(linea);
                    fw.write(linea+"\n");
                }


            }
            fw.close(); // cierra y guarda el flujo de datos en el archivo

        }catch (Exception ex) {
        //ex.printStackTrace(); //imprime la traza completa de la excepcion

            System.out.println(ex.getMessage());

        }
        }
    }
