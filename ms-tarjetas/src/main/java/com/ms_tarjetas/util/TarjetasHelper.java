package com.ms_tarjetas.util;

import java.util.Random;

public class TarjetasHelper {

    static Random random = new Random();

    //Generar una tarjeta
    public static String generarnumTarjeta(){
        StringBuilder referencia = new StringBuilder();
        for(int i=0; i<16; i++){
            int digito = random.nextInt(16);
            referencia.append(digito);
        }
        return referencia.toString();
    }






}
