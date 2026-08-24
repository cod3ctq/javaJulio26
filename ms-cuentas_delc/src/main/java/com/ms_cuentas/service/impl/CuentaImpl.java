package com.ms_cuentas.service.impl;

//Resolución de la lógica de negocio

import com.ms_cuentas.constants.Mensajes;
import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.dto.TipoCuentaRecord;
import com.ms_cuentas.entity.Cuenta;
import com.ms_cuentas.exception.AlreadyExisteSameAccountTypeException;
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

    //inversion de control (IoC): instancia al componente hasta que lo necesites

    //Inyección de dependencias: Consumo/exposición de la funcionalidad de un componente
    //de una manera desacoplada

    //3 formas de inyección de dependencias:
    /*
    1- Atributo - @Autowired
    2- por constructor
    3- Setter @Resource
    */

    @Autowired
    CuentaRepository repo;

    //Cliente http, permite consumir endpoints en clientes externos
    RestTemplate http = new RestTemplate();


    @Override
    public CuentaResponse crearCuenta(CuentaRequest request) {
        //Los datos son extraidos, acomodados y los faltantes generados por el backend dentro del cuentaMapper

        //Validar: un cliente no debe tener mas de 1 cuenta de cada tipo
        //el monto para aperturar cuenta, debe coincidir con el minimo del tipo de cuenta
// añade en el http://host docker.internal
        TipoCuentaRecord record = http.getForObject("http://localhost:8099/api/v1/catalogos/tipo-cuenta/by-id/" + request.getTipoCuentaId(), TipoCuentaRecord.class);
        Cuenta cuenta = null;
        CuentaResponse response = null;

        if (request.getSaldo() < record.saldoMin()) {
            System.out.println("Monto es menor al minimo del tipo de cuenta deseado");
            throw new UnderMinimumException(Mensajes.UNDER_MINIMUM);
        } else if (repo.getAccountByCustomerAndType(request.getClienteId(), request.getTipoCuentaId()).isPresent()) {
            System.out.println("Un cliente no puede tener 2 cuentas del mismo tipo");
            throw new AlreadyExisteSameAccountTypeException(Mensajes.ACCOUNT_TYPE_ALREADY_EXIST);
        } else {
            cuenta = CuentaMapper.toEntity(request);
            //Aqui se guarda el objeto en la base de datos, aquí se le asigna un cuentaID
            repo.save(cuenta);
            //Objeto de salida, transformado por el cuentaService
            response = CuentaMapper.toResponse(cuenta);

        }
        return response;
    }
        @Override
        public CuentaResponse buscarCuenta ( int cuentaId){
            Optional<Cuenta> cuenta = repo.findActiveById(cuentaId);
            if (cuenta.isPresent()){
                return CuentaMapper.toResponse(cuenta.get());
            }else {
                throw new NotExistException(Mensajes.NOT_EXIST);
            }

        }

        @Override
        public CuentaResponse buscarCuenta (String numCuenta){
            Optional<Cuenta> cuenta = repo.findByNumCuenta(numCuenta);

            if (numCuenta.length()!=10){
                throw new BusinessException(Mensajes.INVALID_ACCOUNT_NUMBER);
            }else if (!cuenta.isPresent()){
                throw new NotExistException(Mensajes.NOT_EXIST);

            }else {
                return CuentaMapper.toResponse(cuenta.get());
            }
        }

        @Override
        public CuentaResponse actualizarCuenta (CuentaRequest request){
            //al objeto que ya fui a buscar, lo paso al proceso de
            //actualizacion
            Cuenta cuenta = repo.findById(request.getCuentaId()).get();
            cuenta = CuentaMapper.toUpDateEntity(cuenta, request);
            //Aqui se guarda el objeto en la base de datos, aquí se le asigna un cuentaID
            repo.save(cuenta);
            return CuentaMapper.toResponse(cuenta);
        }

        @Override
        public String eliminar ( int cuentaId){
            repo.deleteById(cuentaId);
            return "Cuenta eliminada";
        }

        @Override
        public String desactivarcuenta (String numCuenta){
            repo.actualizarStatus('0', numCuenta);
            return "Cuenta eliminada";
        }

        @Override
        public List mostrar () {

            List<CuentaResponse> response = new ArrayList<CuentaResponse>();
            for (Cuenta c : repo.getActiveAccounts().get()) {
                response.add(CuentaMapper.toResponse(c));

            }

            return response;
        }
}

