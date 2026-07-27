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
        String cifrado = "";
        // transformamos la cadena en un array

        String[] palabras = texto.split(" ");
        //.split divide la cadena de texto y deuelve un array de Strings


        // cuantas palabras tiene el texto ?
        System.out.println(palabras.length);


        String[] abecedario = {
                "a", "b", "c", "d", "e", "f", "g",
                "h", "i", "j", "k", "l", "m", "n",
                "ñ", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z"
        };


        //iterar

        char caracter;
        int sum=0;
        String especiales = "().,-";
        String letra;

        //normalizamos las variables

        texto = texto.replace(" ","<>"); //reemplaza un caracter especifico por otro nuevo
        System.out.println(texto);


        for (int i = 0; i<texto.length(); i++){
            caracter = texto.charAt(i);
            letra = caracter + "";
            letra = letra.toLowerCase();// convierte a minuscula

            if (Character.isDigit(caracter)){
                sum = sum + Character.getNumericValue(caracter); //temporal

            }else if (especiales.indexOf(caracter)>=0){ //filtra caracteres especiales
                // Reemplazo del caracter
                cifrado = cifrado + "@";
            }else if (letra.equals("z")) { // Asume que es una letra
                cifrado = cifrado + "a";

            }else {

               // determinar en que posisición se encuentra la letra actual
               for (int k=0; k<abecedario.length;k++){
                   if (letra.equals(abecedario[k])){
                       cifrado = cifrado + abecedario[k+1];
                       break;
                   }
               }
            }
        }

        System.out.println("Mensaje cifrado: "+cifrado);
        System.out.println("suma: "+sum);




    }
}
