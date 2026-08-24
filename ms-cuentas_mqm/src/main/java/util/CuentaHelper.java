package util;

import java.util.Random;

public class CuentaHelper {
    static Random random  = new Random();

    //Genera referencias numericas de 16 digitos de manera aletoria
    public static String generarNumCuenta(){
        StringBuilder referencia = new StringBuilder();
        for(int i=0; i<10; i++){
            int digito = random.nextInt(10);
            referencia.append(digito);
        }
        return referencia.toString();
    }

    public static String generarClabe(){
        StringBuilder referencia = new StringBuilder();
        for(int i=0; i<18; i++){
            int digito = random.nextInt(10);
            referencia.append(digito);
        }
        return referencia.toString();
    }
}
