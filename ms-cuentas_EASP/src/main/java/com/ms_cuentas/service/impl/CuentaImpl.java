package com.ms_cuentas.service.impl;

import com.ms_cuentas.constants.Mensajes;
import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.dto.TipoCuentaRecord;
import com.ms_cuentas.entity.Cuenta;
import com.ms_cuentas.exception.AlreadyExistSameAccountTypeException;
import com.ms_cuentas.exception.BussinessException;
import com.ms_cuentas.exception.DoesNotExistException;
import com.ms_cuentas.exception.UnderMinimumException;
import com.ms_cuentas.mapper.CuentaMapper;
import com.ms_cuentas.respository.CuentaRepository;
import com.ms_cuentas.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//Resolucion de la logica de negocio
public class CuentaImpl implements CuentaService {

    //Inversion de Control (IoC)
    //Le otorga el control al framework sobre cuando instanciar al componente (hasta que se necesite)

    //Inyeccion de dependencias: Consumo/Exposicion de la funcionalidad de un componente de una manera desacoplada
    //(Quien lo necesite, lo podra utilizar)

    //3 Formas de inyeccion de dependencias
    /*
    1. Atributo - @Autowired
    2. Por constructor
    3. Setter - @Resource
     */

    @Autowired
    CuentaRepository repo;

    //Cliente http, permite consumir endpoints externos
    RestTemplate http = new RestTemplate();


    @Override
    public CuentaResponse crearCuenta(CuentaRequest request) {
        //Validar:
        //Un cliente no debe tener mas de 1 cuenta del mismo tipo
        //El monto para aperturar cuenta, debe coincidir con el minimo del tipo de cuenta deseado

        TipoCuentaRecord record =
                http.getForObject("http://host.docker.internal:8099/api/v1/catalogos/tipo-cuenta/by-id/" + request.getTipoCuentaId(),
                TipoCuentaRecord.class);
        Cuenta cuenta = null;
        CuentaResponse response = null;

//        Nos dice en que modelo se reciben los datos
        if (request.getSaldo() < record.saldoMin()) {
            throw new UnderMinimumException(Mensajes.UNDER_MINIMUM);
        } else if (repo.getAccountByCustomerAndType(request.getClienteId(), request.getTipoCuentaId()).isPresent()) {
            throw new AlreadyExistSameAccountTypeException(Mensajes.ACCOUNT_TYPE_ALREADY_EXIST);
        } else {
            cuenta = CuentaMapper.toEntity(request); //La logica que teniamos aqui ahora lo hace la Clase CuentaMapper

            //Aqui se guarda el objeto en la base de datos, aqui se le asigna un cuentaId
            repo.save(cuenta);

            //Objeto de salida
            response = CuentaMapper.toResponse(cuenta); //La logica que teniamos aqui ahora lo hace la clase CuentaMapper
        }
        return response;
    }

    @Override
    public CuentaResponse buscarCuenta(int cuentaId) {
        Optional<Cuenta> cuenta = repo.findActiveAccountsById(cuentaId);//Optional es un envoltorio, puede o no traer algo en su interior

        if (cuenta.isPresent()){
            return CuentaMapper.toResponse(cuenta.get());
        }else {
            throw new DoesNotExistException(Mensajes.DOES_NOT_EXIST);
        }
    }

    @Override
    public CuentaResponse buscarCuenta(String numCuenta) {
        Optional<Cuenta> cuenta = repo.findByNumCuenta(numCuenta);

        if (numCuenta.length()!=10){
            throw new BussinessException(Mensajes.INVALID_ACCOUNT_NUMBER);
        }else if (cuenta.isEmpty()) {
            throw new DoesNotExistException(Mensajes.DOES_NOT_EXIST);
        }else {
            return CuentaMapper.toResponse(cuenta.get());
        }

    }

    @Override
    public CuentaResponse actualizarCuenta(CuentaRequest request) {

        Cuenta cuenta = repo.findById(request.getCuentaId()).get();

        //Al objeto de la cuenta que ya fui a buscar lo paso al proceso de actualizacion de datos del Mapper,
        //devolviendome el mismo objeto (dado que el cuentaId no se sobreescribio)
        cuenta = CuentaMapper.toUpdateEntity(cuenta, request);

        repo.save(cuenta);

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
    public List mostrar() { //Solo muestra las cuentas activas

        List<CuentaResponse> response = new ArrayList<CuentaResponse>();
        for (Cuenta c: repo.getActiveAccounts().get()){
            response.add(CuentaMapper.toResponse(c));
        }
        return response;
        //return repo.findAll(); //Devuelve una lista del contenido de la tabla
    }
}
