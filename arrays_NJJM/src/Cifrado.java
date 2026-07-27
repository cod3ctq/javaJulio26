import java.util.Arrays;

public class Cifrado {
    public static void main(String[] args) {

        String texto = "Al contrario del pensamiento popular, el texto de Lorem Ipsum " +
                "no es simplemente texto aleatorio. Tiene sus raices en una pieza clásica " +
                "de la literatura del Latin, que data del año 45 antes de Cristo, haciendo " +
                "que este adquiera mas de 2000 años de antiguedad. Richard McClintock, un " +
                "profesor de Latin de la Universidad de Hampden-Sydney en Virginia, encontró " +
                "una de las palabras más oscuras de la lengua del latín, consecteur, en un " +
                "pasaje de Lorem Ipsum, y al seguir leyendo distintos textos del latín, " +
                "descubrió la fuente indudable. Lorem Ipsum viene de las secciones " +
                "1.10.32 y 1.10.33 de de Finnibus Bonorum et Malorum (Los Extremos del Bien " +
                "y El Mal) por Cicero, escrito en el año 45 antes de Cristo. Este libro es un " +
                "tratado de teoría de éticas, muy popular durante el Renacimiento. " +
                "La primera linea del Lorem Ipsum, Lorem ipsum dolor sit amet, viene de una " +
                "linea en la sección 1.10.32";
        String cifrado="";

        /*
        ¿Cuántas palabras tiene el texto?
         */

        //Transformar la cadena en un array
        String[] palabras = texto.split(" "); //Divide a la cadena de texto, devuelve un array de String

        //System.out.println(Arrays.toString(palabras));
        System.out.println(palabras.length);

        /// ////////////////////////////////////////////////////////////////////////////
        String[] abecedario = {
                "a", "b", "c", "d", "e", "f", "g",
                "h", "i", "j", "k", "l", "m", "n", "ñ",
                "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z"
        };

        //Iterar
        int sumatoria = 0;
        char caracter;
        String especiales = "().,-";
        String letra;

        //Reemplazaun caracter viejo por otro
        texto = texto.replace(" ","<>");
        System.out.println(texto);

        for(int i=0;i<texto.length();i++){
            //System.out.println(texto.charAt(i));
            caracter = texto.charAt(i);
            letra = caracter+"";
            letra = letra.toLowerCase(); //convierte la letra en minúscula

            if(Character.isDigit(caracter)){
                sumatoria =sumatoria + Character.getNumericValue(caracter); //Temporal
            }else if(especiales.indexOf(caracter)>=0){ //Filtrar caracteres especiales
                //reemplazar  el caracter actual
                cifrado = cifrado + "@";
            }else if (letra.equals("z")) {
                cifrado = cifrado + "a";
            }else{
                //Determinar en qué posición está la letra actual
                for (int k=0;k< abecedario.length;k++){
                    if(letra.equals(abecedario[k])){
                        cifrado = cifrado + abecedario[k+1];
                        break;
                    }
                }
            }
        }

        System.out.println("\nMensaje cifrado: "+cifrado);
        System.out.println("Suma "+sumatoria);

        //Resolver el tema del espacio

    }
}
