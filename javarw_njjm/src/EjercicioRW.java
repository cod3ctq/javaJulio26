import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class EjercicioRW {
    public static void main(String[] args) {

        /*
        Transformar fechas digitales a fechas escritas
         */

        String origen = "C:\\Users\\Jafet\\Desktop\\origen.txt";
        String destino = "C:\\Users\\Jafet\\Desktop\\destino.txt";
        File documentoOrigen = new File(origen); //Representación del archivo en memoria
        File documentoDestino = new File(destino); //Representación del archivo en memoria
        String lecturaLinea;
        String[] fechaSeparada;
        String[] numeros = {"","uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve",
                            "diez","once","doce","trece","catorce","quince","dieciseis","diecisiete","dieciocho","diecinueve",
                            "veinte","veintiuno","veintidos","veintitres","veinticuatro","veinticinco","veintiseis","veintisiete","veintiocho","veintinueve",
                            "treinta","treinta y uno"};
        String[] decena = {"treinta","cuarenta","cincuenta","sesenta","setenta","ochenta","noventa"};
        String[] meses = {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
        String dia;
        String mes;
        String anio1, anio2;

        try{
            FileReader fr = new FileReader(documentoOrigen); //Crear un caché de contenido del archivo
            BufferedReader br = new BufferedReader(fr); //Lector del caché
            FileWriter fw = new FileWriter(documentoDestino);

            while ((lecturaLinea = br.readLine()) != null){

                fechaSeparada = lecturaLinea.split("(?<=\\G.{2})");
                //System.out.println(Arrays.toString(fechaSeparada));

                dia = numeros[Integer.parseInt(fechaSeparada[0])];
                //System.out.println(dia);

                mes = meses[Integer.parseInt(fechaSeparada[1])-1];
                //System.out.println(mes);

                if(fechaSeparada[2].equals("19")){
                    anio1 = "mil novecientos";
                }else{
                    anio1 = "dos mil";
                }
                //System.out.println(anio1);

                if(Integer.parseInt(fechaSeparada[3])<30){
                    anio2 = numeros[Integer.parseInt(fechaSeparada[3])];
                }else{
                    anio2 = decena[Character.getNumericValue(fechaSeparada[3].charAt(0))-3]+" y "+numeros[Character.getNumericValue(fechaSeparada[3].charAt(1))];

                }

                //System.out.println(anio2);

                System.out.println(dia+" de "+mes+" de "+anio1+" "+anio2+"\n");
                fw.write(dia+" de "+mes+" de "+anio1+" "+anio2+"\n");

            }

            fw.close();

        }catch(Exception e){
            e.printStackTrace(); //Imrpime la traza completa de la excepción
            System.out.println(e.getMessage()); //Imprime solo el mensaje de la excepción
        }

    }
}
