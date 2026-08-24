package com.ms_cuentas.service.impl;

import com.ms_cuentas.constants.Mensajes;
import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.dto.TipoCuentaRecord;
import com.ms_cuentas.entity.Cuenta;
import com.ms_cuentas.exception.BusinessException;
import com.ms_cuentas.exception.NotExistException;
import com.ms_cuentas.exception.AlreadyExistSameAccountTypeException;
import com.ms_cuentas.exception.UnderMinimumException;
import com.ms_cuentas.mapper.CuentaMapper;
import com.ms_cuentas.repository.CuentaRepository;
import com.ms_cuentas.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Resolucion de la logica de negocio
@Service
public class CuentaServiceImpl implements CuentaService {
    //Inversion de control (IoC): Instancia el componente hasta que lo necesita
    //Inyeccion de dependecias : consumo/exposicion de la funcionalidad de un componente
    //de una manera desacoplada
    //3 formas de inyeccion de dependencias:
    /*
    1.- Atributo
    2.- Por constructor
    3.- Setter -> @Resource
    */
    @Autowired
    CuentaRepository cuentaRepository;

    //Cliente HTTP, permite consumir endpoints externos
    RestTemplate http = new RestTemplate();

    @Override
    public CuentaResponse crearCuenta(CuentaRequest cuentaRequest) {
        TipoCuentaRecord tipoCuentaRecord = http.getForObject("http://host.docker.internal:8099/api/v1/catalogos/tipo-cuenta/by-id/" + cuentaRequest.getTipoCuentaId(),TipoCuentaRecord.class);
        Cuenta cuenta = null;
        CuentaResponse cuentaResponse = null;
        if(cuentaRequest.getSaldo() < tipoCuentaRecord.saldoMin()) {
            throw new UnderMinimumException(Mensajes.UNDER_MINIMUM);
        }
        else if(cuentaRepository.getAccountByCustomerAndType(cuentaRequest.getClienteId(), cuentaRequest.getTipoCuentaId()).isPresent()) {
            throw new AlreadyExistSameAccountTypeException(Mensajes.ACCOUNT_TYPE_ALREADY_EXIST);
        } else {
            //Los datos son extraidos, acomodados y los faltantes generados por el backend
            //dentro
            //validar un cliente no debe de tener mas de una cuenta de cada tipo
            cuenta = CuentaMapper.toEntity(cuentaRequest);
            //Aqi se guarda el objeto en la BD y es aqui se le asigna un cuentaId
            cuentaRepository.save(cuenta);
            //Objeto de salida
            cuentaResponse = CuentaMapper.toResponse(cuenta);
        }
        return cuentaResponse;
    }

    @Override
    public CuentaResponse buscarCuenta(int cuentaId) {
        //Cuenta cuenta = cuentaRepository.findById(cuentaId).get(); //Optional es un envoltorio puede o no puede traer algo en su interior
        Optional<Cuenta> cuentaOptional = cuentaRepository.findActiveByCuentaId(cuentaId);
        if (cuentaOptional.isPresent()) {
            Cuenta cuenta = cuentaOptional.get();
            return CuentaMapper.toResponse(cuenta);
        } else {
            throw new NotExistException(Mensajes.NOT_EXIST);
        }
    }

    @Override
    public CuentaResponse buscarCuenta(String numCuenta) {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findByNumCuenta(numCuenta);
        if(numCuenta.length()!=10){
            throw new BusinessException(Mensajes.INVALID_ACCOUNT_NUMBER);
        } else if(cuentaOptional.isEmpty()) {
            throw new NotExistException(Mensajes.NOT_EXIST);
        } else {
            return CuentaMapper.toResponse(cuentaOptional.get());
        }
    }

    @Override
    public CuentaResponse actualizarCuenta(CuentaRequest cuentaRequest) {
        Cuenta cuenta = cuentaRepository.findActiveByCuentaId(cuentaRequest.getCuentaId()).get();
        //Al objeto de la cuenta que ya fui a buscar, lo paso al proceso de actualizacion de datos del mapper, devolviéndome el mismo
        //objeto, dado que el cuentaId no se sobreescribio
        cuenta = CuentaMapper.toUpdateEntity(cuenta, cuentaRequest);
        //Aqi se guarda el objeto en la BD y es aqui se le asigna un cuentaId
        cuentaRepository.save(cuenta);
        return CuentaMapper.toResponse(cuenta);
    }

    @Override
    public String eliminar(int cuentaId) {
        cuentaRepository.deleteById(cuentaId);
        return "Cuenta eliminada";
    }

    @Override
    public String desactivarCuenta(String numCuenta) {
        //1 UPDATE CUENTAS SET STATUS = WHERE NUM_CUENTA = ??
        //2 BUSCAR LA CUENTA POR METODO --- finBy???
        //DESPUES cuenta.setStatus(0)
        //repo.save(cuenta)
        if(cuentaRepository.actualizarStatus('0', numCuenta)<=0) {
            return "La cuenta no pudo ser eliminada";
        }
        return "La cuenta ha sido eliminada";
    }

    @Override
    public List mostrar() {
        //Opcion 1
        List<CuentaResponse> response = new ArrayList<CuentaResponse>();
        for (Cuenta cuenta : cuentaRepository.getActivateAccounts().get()) {
                response.add(CuentaMapper.toResponse(cuenta));
        }
        return response;
    }
}
