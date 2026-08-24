package com.ms_cuentas.service.impl;

//Resolucion de la logica de negocio


import com.ms_cuentas.constants.Mensajes;
import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.dto.TipoCuentaRecord;
import com.ms_cuentas.entity.Cuenta;
import com.ms_cuentas.exception.AlreadyExistSameAccountTypeException;
import com.ms_cuentas.exception.BusinessException;
import com.ms_cuentas.exception.NotExistException;
import com.ms_cuentas.exception.UnderMinimumException;
import com.ms_cuentas.mapper.CuentaMapper;
import com.ms_cuentas.repository.CuentaRepository;
import com.ms_cuentas.service.CuentaService;
import com.ms_cuentas.util.CuentaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaImpl implements CuentaService {
    //Investigar
    //Inversion de control (IoC) : instancia al componente hasta que lo necesites

    //Inyeccion de dependencias : consumo/exposicion de la funcionalidad de un componente
    //de una manera desacoplada.

    //3 formas de inyeccion de dependencias:
    /*
    1- Atributo - @Autowired
    2- Por constructor
    3- Setter - @Resource
     */

    @Autowired
    CuentaRepository repo;

    //Cliente http, permite consumir ednpoints externos
    RestTemplate http = new RestTemplate();


    @Override
    public CuentaResponse crearCuenta(CuentaRequest request) {
        //Los datos son extraidos, acomodados y los faltantes generados por el backend
        //dentro del cuentaMapper
        //Validar: un cliente no debe tener mas de 1 cuenta de cada tipo
        //el monto para aperturar cuenta, debe coincidir con el minimo del tipo
        // de cuenta elegido
        TipoCuentaRecord record = http.getForObject("http://host.docker.internal:8099/api/v1/catalogos/tipo-cuenta/by-id/"+request.getTipoCuentaId(),TipoCuentaRecord.class);
        Cuenta cuenta = null;
        CuentaResponse response = null;
        if(request.getSaldo()<record.saldoMin()){
            throw new UnderMinimumException(Mensajes.UNDER_MINIMUM);
        }else if(repo.getAccountByCustomerAndType(request.getClienteId(),request.getTipoCuentaId()).isPresent()){
            throw new AlreadyExistSameAccountTypeException(Mensajes.ACCOUNT_TYPE_ALREADY_EXIST);
        }else{
            cuenta = CuentaMapper.toEntity(request);
            //Aqui se guarda el objeto en la base de datos, aqui se le asigna un cuentaId
            repo.save(cuenta);
            //Objeto de salida, trasnformado por el cuentaMapper
            response =  CuentaMapper.toResponse(cuenta);
        }
        return response;
    }
    @Override
    public CuentaResponse buscarCuenta(int cuentaId) {
        //Optional es un envoltorio, puede o no traer algo en su interior
        Optional<Cuenta> cuenta = repo.findActiveById(cuentaId);
        if(cuenta.isPresent()){ //si hay una cuenta en su interior
            return CuentaMapper.toResponse(cuenta.get());
        }else{
            throw new NotExistException(Mensajes.NOT_EXIST);
        }
    }

    @Override
    public CuentaResponse buscarCuenta(String numCuenta) {

        Optional<Cuenta> cuenta = repo.findByNumCuenta(numCuenta);
        if(numCuenta.length()!=10){
            throw new BusinessException(Mensajes.INVALID_ACCOUNT_NUMBER);
        }else if(cuenta.isEmpty()){ //si no hay una cuenta en su interior
            throw new NotExistException(Mensajes.NOT_EXIST);
        }else{
            return CuentaMapper.toResponse(cuenta.get());
        }
    }

    @Override
    public CuentaResponse actualizarCuenta(CuentaRequest request) {
        Cuenta cuenta = repo.findById(request.getCuentaId()).get();
        //Al objeto de la cuenta que ya fui a buscar, lo paso al proceso de
        //actualizacion de datos del mapper, devolviendome el mismo objeto
        //(dado que el cuentaId no se sobreescribio)
        cuenta = CuentaMapper.toUpdateEntity(cuenta,request);
        //Aqui se guarda el objeto en la base de datos, aqui se le asigna un cuentaId
        repo.save(cuenta);
        //Objeto de salida
        return CuentaMapper.toResponse(cuenta);
    }

    @Override
    public String eliminar(int cuentaId) {
        repo.deleteById(cuentaId);
        return "Cuenta eliminada";
    }

    @Override
    public String desactivarCuenta(String numCuenta) {
        repo.actualizarStatus('0',numCuenta);
        return "Cuenta eliminada";
    }

    @Override
    public List mostrar() {
        List<CuentaResponse> response = new ArrayList<CuentaResponse>();
        for(Cuenta c:repo.getActiveAccounts().get()){
            response.add(CuentaMapper.toResponse(c));
        }
        return response;
    }
}
