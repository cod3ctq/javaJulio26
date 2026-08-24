package com.ms_cuentas.util;

import java.util.Random;

public class CuentaHelper {

    static Random random  = new Random();

    //Genera el numero de cuenta de la nueva cuenta
    public static String generarNumCuenta(){
        StringBuilder referencia = new StringBuilder();
        for(int i=0; i<10; i++){
            int digito = random.nextInt(10);
            referencia.append(digito);
        }
        return referencia.toString();
    }

    //Genera el numero de CLABE de la nueva cuenta
    public static String generarClabe(){
        StringBuilder referencia = new StringBuilder();
        for(int i=0; i<18; i++){
            int digito = random.nextInt(10);
            referencia.append(digito);
        }
        return referencia.toString();
    }


}
