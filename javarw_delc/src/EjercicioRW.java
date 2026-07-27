import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EjercicioRW {
    public static void main(String[] args) throws FileNotFoundException {

        /*
        EJERCICIO:
        transformar fechas de numerico a texto...
         */

        String origen = "C:\\Users\\danye\\Desktop\\origen.txt";
        String destino = "C:\\Users\\danye\\Desktop\\destino.txt";

        File file1 = new File(origen);
        File file2 =new File(destino);

        //crear formato de ingrese de fecha ( caso ddmmaaaa)

       // DateTimeFormatter entrada = DateTimeFormatter.ofPattern("ddMMyyyy");

        //crear formato de salida en texto

        //DateTimeFormatter salida = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");

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


        //creamos secuencia de conversion
        try {
            FileReader fr = new FileReader(file1);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(file2);
            int dia;
            int mes;
            String year;
            String anio;

            String linea;
            while ((linea = br.readLine()) != null) {
                dia = Integer.parseInt(linea.substring(0, 2));
                mes = Integer.parseInt(linea.substring(2, 4));
                year = linea.substring(4, linea.length()); // Corrección: Asignación directa de String

                if (year.startsWith("19")) { // Corrección: Uso de 'year' para evaluar el siglo
                    anio = "mil novecientos ";
                } else {
                    anio = "dos mil ";
                }

                // Corrección: Conversión del fragmento de año y eliminación del desfase '-1' si el arreglo 'numeros' incluye el cero
                int indiceAnio = Integer.parseInt(year.substring(2, 4));
                anio = anio + numeros[indiceAnio];

                System.out.println("Fecha: " + numeros[dia] + " de " + meses[mes - 1] + " de " + anio);

                fw.write();


            }
            /*    linea=linea.trim();
                if (!linea.isEmpty()){
                    //se comvierte de numerico a fecha local
                    LocalDate fecha = LocalDate.parse(linea,entrada);

                    //se convierte de local a texto
                    String fechaTexto = fecha.format(salida);

                    System.out.println(fechaTexto);
                    fw.write(linea+"\n");
            */
            fw.close();

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
