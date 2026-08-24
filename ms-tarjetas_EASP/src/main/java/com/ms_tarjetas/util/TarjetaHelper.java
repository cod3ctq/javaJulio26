package com.ms_tarjetas.util;

import java.util.Random;

public class TarjetaHelper {
    static Random random  = new Random();
    public static String generarNumTarjeta(){
        StringBuilder referencia = new StringBuilder();
        for(int i=0; i<16; i++){
            int digito = random.nextInt(10);
            referencia.append(digito);
        }
        return referencia.toString();
    }

    public static String generarNip(){
        StringBuilder referencia = new StringBuilder();
        for(int i=0; i<4; i++){
            int digito = random.nextInt(10);
            referencia.append(digito);
        }
        return referencia.toString();
    }
}
