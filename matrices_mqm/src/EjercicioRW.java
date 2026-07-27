import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class EjercicioRW {
    public static void main(String[] args) {

        String origen="C:\\Users\\not_s\\Desktop\\origen.txt";
        String destino="C:\\Users\\not_s\\Desktop\\destino.txt";
        String linea;
        int day;
        int month;
        String year;
        String anio;
        String fechas;
        String[] dias={
                "Uno","Dos","Tres","Cuatro","Cinco", "Seis", "Siete","Ocho","Nueve","Diez",
                "Once","Doce","Trece","Catorce","Quince", "Dieciseis", "Diecisiete",
                "Dieciocho","Diecinueve","Veinte",
                "Veintiuno","Veintidos","Veintitres","Veinticuatro","Veinticinco", "Veintiseis",
                "Veintisiete","Veintiocho","Veintinueve","Treinta","Treinta y uno", "treinta y dos",
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
        String[] mes = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
                "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        File forigen=new File(origen);
        File fdestino=new File(destino);

        try {
            FileReader fr=new FileReader(forigen);
            BufferedReader br =new BufferedReader(fr);
            FileWriter fw = new FileWriter(fdestino);

            while ((linea= br.readLine())!=null){
                System.out.println(linea);//ddmmaaaa
                day =Integer.parseInt(linea.substring(0,2));//.substring substrae un grupo de 2
                // o 3 o 4 o mas
                // letras o palabras string
                month=Integer.parseInt(linea.substring(2,4));
                year=linea.substring(4,linea.length());

                if (year.startsWith("19")){
                    anio="mil novecientos ";
                }else {
                    anio="dos mil ";
                }
                anio=anio+dias[Integer.parseInt(year.substring(2,4))-1];

                fechas ="Fecha: "+dias[day-1]+" de "+mes[month-1]+" del "+anio;

                fw.write(fechas+"\n");

//                System.out.println(dias[day-1]+" de "+mes[month-1]+" del "+anio);

//              //micodigo  fechas=linea.split("-");
//                //System.out.println(Arrays.toString(fechas));
//
//                for (int i=0; i< fechas.length;i++){
//                    int caracter = Integer.parseInt(String.valueOf(fechas[].charAt(i)));
//                    System.out.println(caracter);
//                    System.out.println(i);
//                    for (int j =0; j<caracter; j++){
//                        if (caracter>2){
//                            System.out.println(dias[j]);
//                        }
//                    }
//                }
            }
            fw.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
