import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class EjercicioRW {
    public static void main(String[] args) {

        String origen = "C:\\Users\\Maria Paola\\OneDrive\\Desktop\\origen.txt";
        File file = new File(origen); //representacion del archivo en memoria
        String linea; // variable auxiliar
        String[] datos;
//        int dia;
//        int mes;
//        int año;
        int day;
        int month;
        String year; //19 96
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
                "diciembre"};

        try {
            FileReader fr = new FileReader(file); //crea un cache del contenido del archivo, copia de lectura en una memoria mas rapida ram
            BufferedReader br = new BufferedReader(fr); //Lector del cache
            File file2 = new File(file);
            FileWriter fw = new FileWriter(file2);


            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

                day = Integer.parseInt(linea.substring(0, 2));
                month = Integer.parseInt(linea.substring(2, 4));
                year = linea.substring(4, linea.length());
                System.out.println(day + ":" + month + ":" + year);
                if (year.startsWith("19")) {
                    anio = "mil novecientos ";
                } else {
                    anio = "dos mil";
                }
                anio = anio + numeros[Integer.parseInt(year.substring(2, 4))-1];
                fechaTexto= "Fecha:" + numeros[day - 1] + " de " + meses[month - 1]+ " de "+ anio;
                //escribe el nuevo archivo
                fw.write(fechaTexto);
            }
        fw.close();

                //filtrar los dias(MI CODIGO)
//                dia = Integer.parseInt(linea.substring(0,2));
//                Integer.parseInt(linea.substring(0,2)); //"10"-- 10
//                System.out.println(dia);
//
//                mes = Integer.parseInt(linea.substring(2,4));
//                Integer.parseInt(linea.substring(2,4));
//                System.out.println(mes);
//
//                año = Integer.parseInt(linea.substring(4,8));
//                Integer.parseInt(linea.substring(4,8));
//                System.out.println(año);
//

                //if (Integer.parseInt(datos[1]) = > 0) {
                    //System.out.println(Arrays.toString(datos));
                //}

        }catch(Exception ex){
            System.out.println(ex.getMessage()); //imprime solo el mensaje del error
        }
    }
}