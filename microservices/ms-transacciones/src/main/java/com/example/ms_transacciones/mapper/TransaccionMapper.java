package com.example.ms_transacciones.mapper;

import com.example.ms_transacciones.dto.TicketResponse;
import com.example.ms_transacciones.dto.TransaccionRequest;
import com.example.ms_transacciones.entity.Cuenta;
import com.example.ms_transacciones.entity.Movimiento;

public class TransaccionMapper {

    public static TicketResponse toResponse(Movimiento mov, Cuenta cuenta){

        TicketResponse response = new TicketResponse(mov.getFecha(),
                mov.getTipo(),
                mov.getMonto(),
                cuenta.getNumCuenta());

        return response;

        //Otra forma de escribir lo anterior
//        return new TicketResponse(mov.getFecha(),
//                mov.getTipo(),
//                mov.getMonto(),
//                cuenta.getNumCuenta());
    }

}
