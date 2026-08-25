package com.ms_transacciones.mapper;

import com.ms_transacciones.dto.TicketResponse;
import com.ms_transacciones.entity.Cuenta;
import com.ms_transacciones.entity.Movimiento;

public class TransaccionesMapper {

    public static TicketResponse toResponse(Movimiento movimiento, Cuenta cuenta) {
        return new TicketResponse
                (
                        movimiento.getFecha(),
                        movimiento.getTipo(),
                        movimiento.getMonto(),
                        cuenta.getNumCuenta()
                );
    }

}
