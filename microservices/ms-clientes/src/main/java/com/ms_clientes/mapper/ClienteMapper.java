package com.ms_clientes.mapper;

import com.ms_clientes.dto.request.ClienteRequest;
import com.ms_clientes.dto.response.ClienteRecord;
import com.ms_clientes.entity.Clientes;

public class ClienteMapper {


    public static Clientes toEntity(ClienteRequest request){
        Clientes c = new Clientes();
        c.setNombre(request.getNombre());
        c.setApP(request.getApP());
        c.setApM(request.getApM());
        c.setCorreo(request.getCorreo());
        c.setDireccion(request.getDireccion());
        c.setTelefono(request.getTelefono());
        c.setIne(request.getIne());
        c.setRfc(request.getRfc());
        c.setFechaNac(request.getFechaNac());
        c.setStatus(1);
        return c;
    }

    public static Clientes toUpdateEntity(Clientes entity, ClienteRequest request){
        entity.setNombre(request.getNombre());
        entity.setApP(request.getApP());
        entity.setApM(request.getApM());
        entity.setCorreo(request.getCorreo());
        entity.setDireccion(request.getDireccion());
        entity.setTelefono(request.getTelefono());
        return entity;
    }

    public static ClienteRecord toResponse(Clientes cliente){
        return new ClienteRecord(cliente.getClienteId(),
                cliente.getNombre() ,cliente.getApP(),cliente.getApM(),
                cliente.getDireccion(), cliente.getTelefono(), cliente.getCorreo());
    }



}
