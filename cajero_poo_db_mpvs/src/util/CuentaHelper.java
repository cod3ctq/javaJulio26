package util;//Clases Helper: CLASES QUE CONTIENEN FUNCIONES DE UTILIDAD USADAS A LO LARGO DE TODO EL PROYECTO

import java.util.Random;

public class CuentaHelper {

    static Random random = new Random();
    //GENERA REFERENCIAS NUMERICAS DE 16 DIGITOS DE MANERA ALEATORIA
    public static String generarReferencia(){
        StringBuilder referencia = new StringBuilder();
        for (int i=0; i<16; i++){
            int digito = random.nextInt(10);
            referencia.append(digito);
        }
        return referencia.toString();
    }
    //GENERA CLAVES NUMERICAS DE 4 DIGITOS DE MANERA ALEATORIA
    public static String generarClave(){
        StringBuilder clave = new StringBuilder();
        for (int i=0; i<4; i++){
            int digito = random.nextInt(10);
            clave.append(digito);
        }
        return clave.toString();
    }
    //
    public static String generarMonto(){
        int base = random.nextInt(99)+1;
        int resultado = base * 100;
        return String.format("%04d",resultado);

    }
}
