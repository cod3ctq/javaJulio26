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
        String cifrado ="";

        //transformar la cadena en un array
        String [] palabras = texto.split(" ");
        //split divide la cadena de texto y devuelve un array de strings

        //cuantas palabras tiene el texto
        System.out.println(palabras.length);

        String[] abecedario = {
                "a", "b", "c", "d", "e", "f", "g",
                "h", "i", "j", "k", "l", "m", "n", "ñ",
                "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z"
        };

        //iterar
        char caracter;
        int sumatoria =0;
        String especiales = "().,-";
        String letra;

        texto = texto.replace(" ","<>");//reemplaza cracter viejo por otro
        System.out.println(texto);

        for (int i=0; i<texto.length();i++){
            caracter = texto.charAt(i);
            letra =caracter+"";//se asigna el puntero del array a 'letra' directamente
            // como String con el +""
            letra = letra.toLowerCase();//convierte las letras a minusculas
            //filtrar
            if (Character.isDigit(caracter)){
                //filtrar numeros
                sumatoria=sumatoria+Character.getNumericValue(caracter);//temporal
            } else if (especiales.indexOf(caracter)>=0) {//filtrar caracteres
                //reemplazar el caracter actual
                cifrado = cifrado +"@";
            }else if (letra.equals("z")){//asume que es una letra
                cifrado = cifrado+"a";
            }else {
                //determinar en que posicion esta la letra actual
                for (int k=0; k<abecedario.length; k++){
                    if (letra.equals(abecedario[k])){
                        cifrado=cifrado+abecedario[k+1];
                        break;
                    }
                }
            }
        }
        System.out.println("Mensaje cifrado: "+cifrado);
        System.out.println("Suma: "+sumatoria);
    }
}
