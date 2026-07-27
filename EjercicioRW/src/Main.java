import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String origen ="C:\\Users\\carlos salatiel\\Desktop\\origen.txt";
        String destino="C:\\Users\\carlos salatiel\\Desktop\\destino.txt";
        File file  = new File(origen);
        File file2 = new File(destino);
        String linea;
        String [] datos;
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
            FileReader fr = new FileReader(file); //contenido del archivo
            BufferedReader br = new BufferedReader(fr); //lecyor del cache
            FileWriter fw= new FileWriter(file2);

            while((linea=br.readLine()) !=null){
                System.out.println(linea);
                day = Integer.parseInt(linea.substring(0,2));
                month = Integer.parseInt(linea.substring(2,4));
                year = linea.substring(4,linea.length());
                System.out.println(day + ":" + month + " : " + year);
                if (year.startsWith("19")){
                    anio=" mil novecientos";
                }else{
                    anio=" dos mil";
                }
                anio=anio +numeros[Integer.parseInt(year.substring(2,4))-1];
                fechaTexto ="fecha :" + numeros[day-1] + " de " + meses [month-1] + " de " + anio;

                fw.write(fechaTexto + "\n");

            }
            fw.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}