import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ejerciciorw {
    public static void main(String[] args) {

        String lectura = "C:\\Users\\cacho\\Desktop\\Origen.txt";
        String escritura = "C:\\Users\\cacho\\Desktop\\destino.txt";

        File file1 = new File(lectura);
        File file2 = new File(escritura);

        String linea;
        String resultado="";

        int dia;
        int mes;
        int año;
        String anio;
        String fechaTexto;

        String[] meses = {"","enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
        String[] unidades = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        String[] especiales = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve"};
        String[] decenas = {"", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
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
        
        try {
            FileReader fr = new FileReader(file1);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw= new FileWriter(file2);

            while ((linea=br.readLine()) !=null){
                dia=Integer.parseInt(linea.substring(0,2));
                mes=Integer.parseInt(linea.substring(2,4));
                año=Integer.parseInt(linea.substring(4,linea.length()));

                if(año == 2000) {
                    anio = "dos mil";

                }else if (año < 2000) {
                        anio = "mil novescientos" + numeros[Integer.parseInt(linea.substring(6, linea.length())) - 1];
                    } else {
                        anio = "dos mil" + numeros[Integer.parseInt(linea.substring(6, linea.length())) - 1];
                }


                System.out.println(dia+","+mes+","+año);
                fechaTexto = ("Fecha: "+numeros[dia-1]+" de "+meses[mes]+" del "+anio);
                //System.out.println(linea);
                fw.write (fechaTexto+"\n"); //"\n" para salto de linea.







            }
            fw.close(); //Cierra y guarda el flujo de datos en el archivo.

        } catch (Exception ex) {
            System.out.println(ex.getMessage());


        }
    }
}
