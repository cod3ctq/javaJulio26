package com.ms_cuentas.service.impl;

import com.ms_cuentas.constants.Mensajes;
import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.dto.TipoCuentaRecord;
import com.ms_cuentas.entity.Cuenta;
import com.ms_cuentas.exception.AlreadyExistSameAccountTypeException;
import com.ms_cuentas.exception.BussinessException;
import com.ms_cuentas.exception.NotExistException;
import com.ms_cuentas.exception.UnderMinimumException;
import com.ms_cuentas.mapper.CuentaMapper;
import com.ms_cuentas.repository.CuentaRepository;
import com.ms_cuentas.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import util.CuentaHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Resolucion de la logica de negocio
@Service //se le indica que sera la clase que resuelva la logica
public class CuentaImpl implements CuentaService {

    //Inyeccion de control: instancia al componente hasta que lo necesites

    //Inyeccion de dependencias: consumo/exposicion de la funcionalidad de un
    // componente de una manera desacoplada

    /*3 formas de inyeccion de dependencias
    1-atributo @Autowired
    2-por constructor
    3-setter @Resource
     */

    @Autowired
    CuentaRepository repo;

    //Cliente http, permite consumir endpoints externos
    RestTemplate http = new RestTemplate();

    @Override
    public CuentaResponse crearCuenta(CuentaRequest request) {

        //validar: un cliente no debe tener mas de 1 cuenta de cada tipo
        //el monto para aperturar cuenta: debe coincidir con el minimo
        // del tipo de cuenta deseado

        TipoCuentaRecord record = http.getForObject(
                //llama de donde se obtendra el dato y como convertira esos datos
                "http://localhost:8092/api/v1/catalogos/tipo-cuenta/by-id/"
//                "http://host.docker.internal:8099/api/v1/catalogos/tipo-cuenta/by-id/"
                +request.getTipoCuentaId(),
                TipoCuentaRecord.class);

        Cuenta cuenta = null;
        CuentaResponse response = null;

        if (request.getSaldo()<record.saldoMin()){
            throw new UnderMinimumException(Mensajes.UNDER_MINIMUM);
        } else if (repo.getAccountByCustomerAndType(
                request.getClienteId(),
                request.getTipoCuentaId()).isPresent()) {
            throw new AlreadyExistSameAccountTypeException(Mensajes.ACCOUNT_TYPE_ALREADY_EXIST);
        }else {
            cuenta = CuentaMapper.toEntity(request);
            repo.save(cuenta);
            response = CuentaMapper.toResponse(cuenta);
        }
        return response;
        //los datos son extraidos, acomodados y los faltantes
        // generados por el backend
        //dentro del cuenta mapper
//        Cuenta cuenta = CuentaMapper.toEntity(request);

//        cuenta.setClienteId(request.getClienteId());
//        cuenta.setTipoCuentaId(request.getTipoCuentaId());
//        cuenta.setSaldo(request.getSaldo());
//        cuenta.setFecha(LocalDate.now());
//        cuenta.setStatus('1');
//        cuenta.setNumCuenta(CuentaHelper.generarNumCuenta());
//        cuenta.setClabe(CuentaHelper.generarClabe());

        //aqui se guarda el objeto en la base de datos,
        //tambien se le asigna un cuentaId
        //para usar el framework, solicita el uso de una entidad, por eso
        // se debe tener el objeto de la entidad creado
//        repo.save(cuenta);

        //se necesita donde devolver la informacion obtenida
        //objeto de salida
//        CuentaResponse response = new CuentaResponse(cuenta.getCuentaId(),
//                cuenta.getTipoCuentaId(), cuenta.getNumCuenta(), cuenta.getClabe(),
//                cuenta.getSaldo(),cuenta.getFecha());

        //objeto de salida, transformado por el cuentaMapper
//        return CuentaMapper.toResponse(cuenta);
    }

    @Override
    public CuentaResponse buscarCuenta(int cuentaId) {

        //findby es un opcional
        //optional es un envoltorio, puede o no traer algo en su interior,
        // con get se obliga a ver que es lo que tiene el envoltorio

        //Cuenta cuenta = repo.findById(cuentaId).get();

        Optional<Cuenta> cuenta = repo.findActiveById(cuentaId);
        if (cuenta.isPresent()){
            return CuentaMapper.toResponse(cuenta.get());
            //al ser cuenta un optional se trae lo que tiene en su interior con .get
        }else {
            throw new NotExistException(Mensajes.NOT_EXIST);
        }
//        CuentaResponse response = new CuentaResponse(cuenta.getCuentaId(),
//                cuenta.getTipoCuentaId(), cuenta.getNumCuenta(), cuenta.getClabe(),
//                cuenta.getSaldo(),cuenta.getFecha());
    }

    @Override
    public CuentaResponse buscarCuenta(String numCuenta) {

        Optional <Cuenta> cuenta = repo.findByNumCuenta(numCuenta);

        if (numCuenta.length()!=10){
            throw new BussinessException(Mensajes.INVALID_ACCOUNT_NUMBER);
        }else if (cuenta.isEmpty()){ //si no hay una cuenta en su interior
            throw new NotExistException(Mensajes.NOT_EXIST);
        }else {
            return CuentaMapper.toResponse(cuenta.get());
        }
    }

    @Override
    public CuentaResponse actualizarCuenta(CuentaRequest request) {
        //busca la informacion en la base y obtiene el ultimo valor de la base
        Cuenta cuenta = repo.findById(request.getCuentaId()).get();

        //Al objeto de la cuenta que ya fui a buscar, lo paso al proceso de
        // actualizacion de datos del mapper, devolviendome el mismo objeto
        //dado que el cuentaId no se sobreescribio
        cuenta = CuentaMapper.toUpdateEntity(cuenta, request);

        //sobreescribe la informacion
//        cuenta.setClienteId(request.getClienteId());
//        cuenta.setTipoCuentaId(request.getTipoCuentaId());
//        cuenta.setSaldo(request.getSaldo());
//        cuenta.setFecha(LocalDate.now());
//        cuenta.setStatus('1');
//        cuenta.setNumCuenta(CuentaHelper.generarNumCuenta());
//        cuenta.setClabe(CuentaHelper.generarClabe());

        //guarda la informacion obtenida sobreescrita
        //guarda el objeto en la base de datos, aqui se le asigna un cuentaId
        repo.save(cuenta);

        //objeto de salida
//        CuentaResponse response = new CuentaResponse(cuenta.getCuentaId(),
//                cuenta.getTipoCuentaId(), cuenta.getNumCuenta(), cuenta.getClabe(),
//                cuenta.getSaldo(),cuenta.getFecha());

        return CuentaMapper.toResponse(cuenta);
    }

    @Override
    public String eliminar(int cuentaId) {
        repo.deleteById(cuentaId);
        return "Cuenta eliminada";
    }

    @Override
    public String desactivarCuenta(String numCuenta) {
        //escenario 1 UPDATE SET STATUS = 0 WHERE NUM_CUENTA = numCuenta
        repo.actualizarStatus('0',numCuenta);

        //escenario 2 buscar la cuenta -- findBy?? no existe (existe la
        // busqueda de metodos por nombre Query Methods
        // (List<Cuenta> findByStatusAndNumCuenta(char status, String numCuenta);)
        // pero por regla del spring JPA no se premite usarlo para reemplazar informacion
        // solo para operaciones findBy, readBy, countBy y deleteBy),
        // JPA tiene consultas SENCILLAS 0las cuales no permiten hacer consultas muy elavoradas

        return "Cuenta desactivada";
    }

    @Override
    public List mostrar() {
        List<CuentaResponse> response = new ArrayList<CuentaResponse>();
        for (Cuenta c : repo.getActiveAccounts().get()){
            if (c.getStatus()=='1') {
//            response.add(new CuentaResponse(c.getCuentaId(),
//                    c.getTipoCuentaId(),
//                    c.getNumCuenta(),
//                    c.getClabe(),
//                    c.getSaldo(),
//                    c.getFecha()));
                response.add(CuentaMapper.toResponse(c));
            }
        }
        return response;
    }
}
