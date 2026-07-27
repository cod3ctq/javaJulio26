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

        System.out.println(texto);
        String cifrado = "";

        //Cuantas palabras tiene el texto

        //Transformamos la cadena en un Array
        String[] palabras = texto.split(" ");
        System.out.println(palabras.length);

        //Transformar hasta la primer coma en lo siguiente:
        //Cada letra debe convertirse en la siguiente del abecedario y los espacios en %

        String[] abecedario = {
                "a", "b", "c", "d", "e", "f", "g",
                "h", "i", "j", "k", "l", "m", "n", "ñ",
                "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z"
        };

        //Iterar
        char caracter;
        int sumatoria = 0;
        String especiales = "().,-";
        String letra;

        texto = texto.replace(" ","<>"); //reemplaza un caracter viejo por otro
        System.out.println(texto);

        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);

            if (Character.isDigit(caracter)) {
                sumatoria = sumatoria + Character.getNumericValue(caracter); //Temporal numeros

            } else if (especiales.indexOf(caracter) >= 0) {//Filtrar caracteres
                cifrado = cifrado + "@";

            } else { //Asumimos que es una letra
                letra = caracter + "";
                letra = letra.toLowerCase(); //Transformamos a minuscula para poderla encontrar en el Array de letras

                if (letra.equals("z")){
                    cifrado = cifrado + "a";

                } else {
                    for (int k=0; k< (abecedario.length)-1; k++){
                        if (letra.equals(abecedario[k])){
                            cifrado = cifrado + abecedario[k+1];
                            break;
                        }
                    }
                }
            }


            //Determinar en que posicion está la letra actual

        }
        System.out.println(cifrado);
        System.out.println("Suma: "+sumatoria);
    }


}

