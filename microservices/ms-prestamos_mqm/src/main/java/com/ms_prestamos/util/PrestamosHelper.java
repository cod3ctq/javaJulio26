package com.ms_prestamos.util;

import com.ms_prestamos.entity.Prestamos;

import java.time.LocalDate;

public class PrestamosHelper {

    public static LocalDate fechaFin() {

        LocalDate fecha = LocalDate.now();
        LocalDate fechaFutura = fecha.plusYears(100);
        // Suma 100 años
        return fechaFutura;
    }

}
