package com.ms_transacciones.mapper;

import com.ms_transacciones.dto.TicketResponse;
import com.ms_transacciones.dto.TransaccionRequest;
import com.ms_transacciones.entity.Cuenta;
import com.ms_transacciones.entity.Movimiento;

public class TransaccionMapper {

    public static TicketResponse toResponse(Movimiento mov, Cuenta cuenta){

        return new TicketResponse(
                mov.getFecha(),
                mov.getTipo(),
                mov.getMonto(),
                cuenta.getNumCuenta());
    }
}
