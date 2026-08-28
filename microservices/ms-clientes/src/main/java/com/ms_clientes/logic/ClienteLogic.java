package com.ms_clientes.logic;

import com.ms_clientes.constants.Mensajes;
import com.ms_clientes.dto.request.ClienteRequest;
import com.ms_clientes.dto.response.ClienteRecord;
import com.ms_clientes.entity.Clientes;
import com.ms_clientes.exception.AlreadyExistException;
import com.ms_clientes.exception.ResourceNotFoundException;
import com.ms_clientes.mapper.ClienteMapper;
import com.ms_clientes.repository.ClienteRepository;
import com.ms_clientes.service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteLogic implements ClienteService {

    @Autowired
    ClienteRepository repo;

    @Override
    public ClienteRecord guardar(ClienteRequest request) {
        Clientes cliente = null;

        //Validaciones de negocio
        if(repo.findByTelefono(request.getTelefono()).isPresent()){
            throw new AlreadyExistException(Mensajes.ALREADY_EXIST);
        }else if(repo.findByCorreo(request.getCorreo()).isPresent()){
            throw new AlreadyExistException(Mensajes.ALREADY_EXIST);
        }else if(repo.findByDireccion(request.getDireccion()).isPresent()){
            throw new AlreadyExistException(Mensajes.ALREADY_EXIST);
        }else if(repo.findByRfc(request.getRfc()).isPresent()){
            throw new AlreadyExistException(Mensajes.ALREADY_EXIST);
        }else if(repo.findByIne(request.getIne()).isPresent()){
            throw new AlreadyExistException(Mensajes.ALREADY_EXIST);
        }else{

            cliente = ClienteMapper.toEntity(request);
            repo.save(cliente);
            return ClienteMapper.toResponse(cliente);

        }
    }

    @Override
    public ClienteRecord actualizar(ClienteRequest request) {

        Clientes cliente = null;

        if(repo.findById(request.getClienteId()).isEmpty()){
            throw new ResourceNotFoundException(Mensajes.NOT_FOUND);
        }else if(repo.findByTelefono(request.getTelefono()).isPresent()){
            throw new AlreadyExistException(Mensajes.ALREADY_EXIST);
        }else if(repo.findByCorreo(request.getCorreo()).isPresent()){
            throw new AlreadyExistException(Mensajes.ALREADY_EXIST);
        }else if(repo.findByDireccion(request.getDireccion()).isPresent()){
            throw new AlreadyExistException(Mensajes.ALREADY_EXIST);
        }else if(repo.findByRfc(request.getRfc()).isPresent()){
            throw new AlreadyExistException(Mensajes.ALREADY_EXIST);
        }else if(repo.findByIne(request.getIne()).isPresent()){
            throw new AlreadyExistException(Mensajes.ALREADY_EXIST);
        }else{
            cliente = ClienteMapper.toUpdateEntity(repo.findById(request.getClienteId()).get(),request);
            repo.save(cliente);

            //Record es el nuevo response
            return ClienteMapper.toResponse(cliente);

        }
    }

    @Override
    public ClienteRecord buscar(String nombreCompleto) {

        Clientes c = null;
        String[] nc = nombreCompleto.split(" "); //[Pablo Marmol Lopez]
        if(repo.findByNombreCompleto(nc[0],nc[1],nc[2]).isEmpty()){
            throw new ResourceNotFoundException(Mensajes.NOT_FOUND);
        }else{
            c  = repo.findByNombreCompleto(nc[0],nc[1],nc[2]).get();
            return ClienteMapper.toResponse(c);
        }

    }


    @Override
    public String eliminar(int clienteId) {
        repo.deleteById(clienteId);
        return "Eliminado";
    }

    @Override
    public List mostrar() {

        List <ClienteRecord> lista = new ArrayList<ClienteRecord>();
        for(Clientes cliente : repo.findAllActives()){
            lista.add(ClienteMapper.toResponse(cliente));
        }
        return lista;
    }
}
