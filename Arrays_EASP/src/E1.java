import java.util.Arrays;

public class E1 {
    public static void main(String[] args) {

        //Iterar sobre este array
        String[] valores = {"4","G","6","b","5","7","1","K","8","A","3","J","4","3","6",
                "7","2","B","A","R","9","6","1","w","Q","V","6","L","2","7"};
        //Filtrar:-si el valor actual es un numero par, multiplicar por 5
        //         guardar el resultado en la misma posicion en el array de resultados
        //Filtrar:-Si el valor actual e un numero impar, dividir entre 3
        //         guardar el resultado en la misma posicion en el array de resultados
        //        -Si es una letra, colocar un '@' en la misma posicion del array de resultados

        Object[] resultados = new Object[valores.length];

        double n = 0;


        String numeros = "0123456789";
        String caso = "";

        //System.out.println(Arrays.toString(numeros));

        for(int i=0; i < valores.length; i++) {
            caso=valores[i];

            if (numeros.contains(caso)) {
                n=Integer.parseInt(caso);

                if (n % 2 == 0) {
                    resultados[i] = Math.round(n * 5);
                } else {
                    resultados[i] = Math.round((n / 3) * 100.0) / 100.0; //Limita a 2 decimales.
                }

            } else {
                resultados[i] = '@';
            }

        }
        System.out.println(Arrays.toString(valores));
        System.out.println(Arrays.toString(resultados));





    }
}
