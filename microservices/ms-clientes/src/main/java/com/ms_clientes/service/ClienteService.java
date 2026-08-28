package com.ms_clientes.service;

import com.ms_clientes.dto.request.ClienteRequest;
import com.ms_clientes.dto.response.ClienteRecord;

import java.util.List;

public interface ClienteService {

    ClienteRecord guardar(ClienteRequest request);
    ClienteRecord actualizar(ClienteRequest request);
    ClienteRecord buscar(String nombreCompleto); //usar AND en la consulta JPQL
    String eliminar(int clienteId);
    List mostrar();


}
