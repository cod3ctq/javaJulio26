package com.ms_clientes.dto.response;

import java.time.LocalDate;

public record ClienteRecord(int clienteId, String nombre,String apP, String apM, String direccion, String tel, String correo) {
}
