import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ejerciciorw {
    public static void main(String[] args) {

        //

        String lectura = "C:\\Users\\edtom\\Documents\\CETEQ\\archivos\\origen.txt";
        String escritura = "C:\\Users\\edtom\\Documents\\CETEQ\\archivos\\destino.txt";

        File file = new File(lectura); //Representacion del archivo en memoria
        File file2 = new File(escritura);

        // LOGICA DEL PROFE

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

        int day;
        int month;
        String year;
        String anio;
        String fechaTexto;


        String linea; //Variable auxiliar

        /*String dia [] = { LOGICA MIA
                "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez",
                "Once", "Doce", "Trece", "Catorce", "Quince", "Dieciseis", "Diecisiete", "Dieciocho", "Diecinueve", "Veinte",
                "Veintiuno", "Veintidos", "Veintitres", "Veinticuatro", "Veinticinco", "Veintiseis", "Veintisiete", "Veintiocho", "Veintinueve", "Treinta",
                "Treintaiuno"
        };

        String mes [] = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
                "Noviembre", "Diciembre"
        };*/

        try {
            FileReader fr = new FileReader(file); //Crear un cache de contenido del archivo
            BufferedReader br = new BufferedReader(fr); //Leer el contenido del cache

            FileWriter fw = new FileWriter(file2);

            while((linea = br.readLine()) != null){

                day = Integer.parseInt(linea.substring(0,2));
                month = Integer.parseInt(linea.substring(2,4));
                year = String.valueOf(Integer.parseInt(linea.substring(4,linea.length())));

                if(year.startsWith("19")) {
                    anio = "Mil novecientos";
                } else {
                    anio = "Dos mil";
                }

                if(Integer.parseInt(year.substring(2,4))==00) {
                    anio = "Dos mil";
                }else{
                    anio += " " + numeros[Integer.parseInt(year.substring(2,4))-1];
                }
                System.out.println(day + "/" + month + "/" + year);
                System.out.println(numeros[day-1] + " " + meses[month-1] + " " + anio);
                fechaTexto = numeros[day-1] + " de " + meses[month-1] + " de " + anio + "\n";
                fw.write(fechaTexto);

                /*System.out.println("Dia: " + linea.substring(0, 2) + "\n" +
                                   "Mes: " + linea.substring(2, 4) + "\n" +
                                   "Año: " + linea.substring(4, 8));

                switch(linea.substring(4, 8)){
                    case "1990":
                        year = "Mil novecientos noventa";
                        break;
                    case "1991":
                        year = "Mil novecientos noventa y uno";
                        break;
                    case "1992":
                        year = "Mil novecientos noventa y dos";
                        break;
                    case "1993":
                        year = "Mil novecientos noventa y tres";
                        break;
                    case "1994":
                        year = "Mil novecientos noventa y cuatro";
                        break;
                    case "1995":
                        year = "Mil novecientos noventa y cinco";
                        break;
                    case "1996":
                        year = "Mil novecientos noventa y seis";
                        break;
                    case "1997":
                        year = "Mil novecientos noventa y siete";
                        break;
                    case "1998":
                        year = "Mil novecientos noventa y ocho";
                        break;
                    case "1999":
                        year = "Mil novecientos noventa y nueve";
                        break;
                    case "2000":
                        year = "Dos mil";
                        break;
                    case "2001":
                        year = "Dos mil uno";
                        break;
                    case "2002":
                        year = "Dos mil dos";
                        break;
                    case "2003":
                        year = "Dos mil tres";
                        break;
                    case "2004":
                        year = "Dos mil cuatro";
                        break;
                    case "2005":
                        year = "Dos mil cinco";
                        break;
                    case "2006":
                        year = "Dos mil seis";
                        break;
                    case "2007":
                        year = "Dos mil siete";
                        break;
                    case "2008":
                        year = "Dos mil ocho";
                        break;
                    case "2009":
                        year = "Dos mil nueve";
                        break;
                    case "2010":
                        year = "Dos mil diez";
                        break;
                    case "2011":
                        year = "Dos mil once";
                        break;
                    case "2012":
                        year = "Dos mil doce";
                        break;
                    case "2013":
                        year = "Dos mil trece";
                        break;
                    case "2014":
                        year = "Dos mil catorce";
                        break;
                    case "2015":
                        year = "Dos mil quince";
                        break;
                    case "2016":
                        year = "Dos mil dieciseis";
                        break;
                    case "2017":
                        year = "Dos mil diecisiete";
                        break;
                    case "2018":
                        year = "Dos mil dieciocho";
                        break;
                    case "2019":
                        year = "Dos mil diecinueve";
                        break;
                    case "2020":
                        year = "Dos mil veinte";
                        break;
                    case "2021":
                        year = "Dos mil veintiuno";
                        break;
                    case "2022":
                        year = "Dos mil veintidos";
                        break;
                    case "2023":
                        year = "Dos mil veintitres";
                        break;
                    case "2024":
                        year = "Dos mil veinticuatro";
                        break;
                    case "2025":
                        year = "Dos mil veinticinco";
                        break;
                }
                System.out.println(dia[Integer.parseInt(linea.substring(0, 2)) - 1] + " de " +mes[Integer.parseInt(linea.substring(2, 4)) - 1] + " de " + year);
                fw.write(dia[Integer.parseInt(linea.substring(0, 2)) - 1] + " de " +mes[Integer.parseInt(linea.substring(2, 4)) - 1] + " de " + year + "\n");*/
            }

            fw.close(); // Cierra y guarda el flujo de datos en el archivo
        } catch (Exception ex) {
            //ex.printStackTrace(); //Imprime la traza completa de la excepcion
            System.out.println(ex.getMessage());
        }

    }
}
