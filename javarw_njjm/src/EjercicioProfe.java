import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EjercicioProfe {
    public static void main(String[] args) {

        String lectura ="C:\\Users\\Jafet\\Desktop\\origen.txt";
        String escritura = "C:\\Users\\Jafet\\Desktop\\escritura2.txt";
        File file = new File(lectura); //Representación del archivo en memoria
        File file2 = new File(escritura); //Representación del archivo en memoria
        String linea; //aux
        int day;
        int month;
        String year;
        String anio;
        String fechaTexto;

        String[] numeros = {
                "uno",
                "dos",
                "tres",
                "cuatro",
                "cinco",
                "seis",
                "siete",
                "ocho",
                "nueve",
                "diez",
                "once",
                "doce",
                "trece",
                "catorce",
                "quince",
                "dieciséis",
                "diecisiete",
                "dieciocho",
                "diecinueve",
                "veinte",
                "veintiuno",
                "veintidós",
                "veintitrés",
                "veinticuatro",
                "veinticinco",
                "veintiséis",
                "veintisiete",
                "veintiocho",
                "veintinueve",
                "treinta",
                "treinta y uno",
                "treinta y dos",
                "treinta y tres",
                "treinta y cuatro",
                "treinta y cinco",
                "treinta y seis",
                "treinta y siete",
                "treinta y ocho",
                "treinta y nueve",
                "cuarenta",
                "cuarenta y uno",
                "cuarenta y dos",
                "cuarenta y tres",
                "cuarenta y cuatro",
                "cuarenta y cinco",
                "cuarenta y seis",
                "cuarenta y siete",
                "cuarenta y ocho",
                "cuarenta y nueve",
                "cincuenta",
                "cincuenta y uno",
                "cincuenta y dos",
                "cincuenta y tres",
                "cincuenta y cuatro",
                "cincuenta y cinco",
                "cincuenta y seis",
                "cincuenta y siete",
                "cincuenta y ocho",
                "cincuenta y nueve",
                "sesenta",
                "sesenta y uno",
                "sesenta y dos",
                "sesenta y tres",
                "sesenta y cuatro",
                "sesenta y cinco",
                "sesenta y seis",
                "sesenta y siete",
                "sesenta y ocho",
                "sesenta y nueve",
                "setenta",
                "setenta y uno",
                "setenta y dos",
                "setenta y tres",
                "setenta y cuatro",
                "setenta y cinco",
                "setenta y seis",
                "setenta y siete",
                "setenta y ocho",
                "setenta y nueve",
                "ochenta",
                "ochenta y uno",
                "ochenta y dos",
                "ochenta y tres",
                "ochenta y cuatro",
                "ochenta y cinco",
                "ochenta y seis",
                "ochenta y siete",
                "ochenta y ocho",
                "ochenta y nueve",
                "noventa",
                "noventa y uno",
                "noventa y dos",
                "noventa y tres",
                "noventa y cuatro",
                "noventa y cinco",
                "noventa y seis",
                "noventa y siete",
                "noventa y ocho",
                "noventa y nueve",
                "cien"
        };

        String[] meses = {
                "enero",
                "febrero",
                "marzo",
                "abril",
                "mayo",
                "junio",
                "julio",
                "agosto",
                "septiembre",
                "octubre",
                "noviembre",
                "diciembre"
        };

        try{
            FileReader fr = new FileReader(file); //Crear un caché de contenido del archivo
            BufferedReader br = new BufferedReader(fr); //Lector del caché
            FileWriter fw = new FileWriter(file2);

            while((linea=br.readLine()) !=null){ //Lectura del caché

                day = Integer.parseInt(linea.substring(0,2));
                month = Integer.parseInt(linea.substring(2,4));
                year = linea.substring(4,linea.length());

                System.out.println(day+":"+month+":"+year);
                //Dependiendo del año, coloca "mil novecientos" o "dos mil" para el año
                if(year.startsWith("19")){
                    anio="mil novecientos ";
                }else{
                    anio="dos mil ";
                }

                if(Integer.parseInt(year.substring(2,4))==0){
                    anio = anio + " ";
                }else{
                    anio = anio + numeros[Integer.parseInt(year.substring(2,4))-1];
                }



                System.out.println("Fecha: "+numeros[day-1]+" de "+meses[month-1]+" de "+anio);
                fechaTexto = "Fecha: "+numeros[day-1]+" de "+meses[month-1]+" de "+anio;
                fw.write(fechaTexto+"\n");

            }
            fw.close(); //Cierra y guarda el flujo de datos en el archivo

        }catch (Exception ex){
            ex.printStackTrace(); //Imrpime la traza completa de la excepción
            System.out.println(ex.getMessage()); //Imprime solo el mensaje de la excepción
        }
    }
}




