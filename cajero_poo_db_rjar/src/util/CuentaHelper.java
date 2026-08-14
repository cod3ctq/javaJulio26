package util;

import java.util.Random;

public class CuentaHelper {

    //Clase Helper: Clases que continne funiones de utilidad usadas a lo largo de todo el proyecto
    static Random random =new Random();
    //Genera referencias numericas de 16 digitos de manera aleatoria
    public static String generarReferencia(){
        StringBuilder referencia = new StringBuilder();
        for(int i=0; i<16; i++){
            int digito=random.nextInt(10);
            referencia.append(digito);
        }
        return referencia.toString();
    }
    //Genera claves numericas de 4 digitos de manera aleatoria
    public static String generarClave() {
        StringBuilder clave = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digito = random.nextInt(10);
            clave.append(digito);
        }
        return clave.toString();
    }
    //Genra cantidades aleatorias, siempre on multiplos de 100
    public static String generrarMonto(){
        int base= random.nextInt(99)+1;
        int resultado= base *100;
        return String.format("%04d",resultado);

    }
}
