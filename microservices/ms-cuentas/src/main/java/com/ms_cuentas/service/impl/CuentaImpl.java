package com.ms_cuentas.service.impl;

import com.ms_cuentas.constants.Mensajes;
import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.dto.TarjetaRecord;
import com.ms_cuentas.dto.TipoCuentaRecord;
import com.ms_cuentas.entity.Cuenta;
import com.ms_cuentas.exception.*;
import com.ms_cuentas.mapper.CuentaMapper;
import com.ms_cuentas.repository.CuentaRepository;
import com.ms_cuentas.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Resolución de la lógica de negocio
@Service
public class CuentaImpl implements CuentaService {

    //Inversión de control (IoC): Instacía al componente hasta que lo necesites

    //Inyección de dependencias: consumo/exposición de la funcionalidad de un componente
    //de una manera desacoplada

    //3 formas de inyección de dependencias:
    /*
    1- Atributo - @Autowired
    2- Por constructor
    3- Setter - @Resource
     */

    @Autowired //Instanciamiento hasta que CuentaImpl lo requiera
    CuentaRepository repo;

    //Cliente http, permite consumir endpoints externos
    RestTemplate http = new RestTemplate();

    @Override
    public CuentaResponse crearCuenta(CuentaRequest request) {
        //Los datos son extraidos, acomodades y los faltantes generados por el backend dentro del cuentaMapper

        //Validar: un cliente no debe tener más de 1 cuenta de cada tipo
        //el monto para aperturar cuenta, dbe coincidir con el mínimo del tipo de cuenta elegido
        TipoCuentaRecord record = http.getForObject(
                "http://localhost:8092/api/v1/catalogos/tipo-cuenta/by-id/"+request.getTipoCuentaId(),
                TipoCuentaRecord.class);

        Cuenta cuenta = null;
        CuentaResponse response = null;
//        if(repo.existsByCuentaId(request.getCuentaId())){
//            throw new AccountWithAlreadyRegisteredCard(Mensajes.ALREADY_REGISTERED_CARD);
//        }else
            if(request.getSaldo()<record.saldoMin()){
            throw new UnderMinimumException(Mensajes.UNDER_MINIMUM);
        }else if(repo.getAccountsByCustomerAndType(request.getClienteId(),request.getTipoCuentaId()).isPresent()){
            //Se crea método en CuentaRepository (getAccountsByCusomer...)
            throw new AlreadyExistSameAccountTypeException(Mensajes.ACCOUNT_TYPE_ALREADY_EXIST);
        }else{
            cuenta = CuentaMapper.toEntity(request);

            //Aquí se guarda el objeto en la base de datos, aquí se le asigna un cuentaId
            repo.save(cuenta); //Esto hace que todo lo que se guarda en la entidad cuenta se mande a la base de datos

            //Objeto de salida (hacia el cliente)

            response = CuentaMapper.toResponse(cuenta);
        }
        return response;


    }

    @Override
    public CuentaResponse buscarCuenta(int cuentaId) {
        //Optional es un envoltorio, puede o no traer algo en su interior
        Optional<Cuenta> cuenta = repo.findActiveById(cuentaId);

        if(cuenta.isPresent()){//Si hay una cuenta en su interior
            return CuentaMapper.toResponse(cuenta.get());
        }else {
            throw new NotExistException(Mensajes.NOT_EXIST);
        }


    }

    @Override
    public CuentaResponse buscarCuenta(String numCuenta) {

        Optional<Cuenta> cuenta = repo.findByNumCuenta(numCuenta);

        if(numCuenta.length()!=10){
            throw new BusinessException(Mensajes.INVALID_ACCOUNT_NUMBER);
        }else if(cuenta.isEmpty()){
            throw new NotExistException(Mensajes.NOT_EXIST);
        }else {
            return CuentaMapper.toResponse(cuenta.get());
        }

    }

    @Override
    public CuentaResponse actualizarCuenta(CuentaRequest request) {
        Cuenta cuenta = repo.findById(request.getCuentaId()).get();

        //Al objeto de la cuenta que ya fui a buscar, lo paso a proceso de actualización de datos
        //al mapper, devolviéndome el mismo objeto (dado que el cuentaId no se sobreescribió)
        cuenta = CuentaMapper.toUpdateEntity(cuenta,request);

        //Aquí se guarda el objeto en la base de datos, aquí se le asigna un cuentaId
        repo.save(cuenta); //Esto hace que todo lo que se guarda en la entidad cuenta se mande a la base de datos

        //Objeto de salida (hacia el cliente)

        return CuentaMapper.toResponse(cuenta);
    }

    @Override
    public String eliminar(int cuentaId) {
        repo.deleteById(cuentaId);
        return "Cuenta eliminada";
    }

    @Override
    public String desactivarCuenta(String numCuenta) {
        //1 UPDATE CUENTAS SET STATUS = 0 WHERE NUM_CUENTA = ???

        //2 BUSCAR LA CUENTA -- findBy???
        // cuenta.setStatus(0)
        // repo.save(cuenta);
        repo.actualizarStatus('0',numCuenta);
        return "Cuenta eliminada";
    }

    @Override
    public List mostrar() {
        List<CuentaResponse> response = new ArrayList<CuentaResponse>();
        for(Cuenta c : repo.getActiveAccounts().get()){
            response.add(CuentaMapper.toResponse(c));
        }
        return response;
    }
}
