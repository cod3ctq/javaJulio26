package com.ms_cuentas.service.impl;


import com.ms_cuentas.constants.Mensajes;
import com.ms_cuentas.dto.CuentaRequest;
import com.ms_cuentas.dto.CuentaResponse;
import com.ms_cuentas.dto.TipoCuentaRecord;
import com.ms_cuentas.entity.Cuenta;
import com.ms_cuentas.exception.AlreadyExistSameAccountException;
import com.ms_cuentas.exception.BussinessException;
import com.ms_cuentas.exception.NotExistException;
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

//Resolucion de la ligoca de negocio
@Service
public class CuentaImpl implements CuentaService {

    //Inversion de control (IoC) : Instancia al componenete hasta que lo necesites.

    //Inyeccion de dependencias : Consumo/exposicion de la funcionalidad de un
    //componente de una manera desacoplada.

    //3 formas de inyeccion de dependencias:
    //1. Atributo - @Autowired
    //2. Por constructor
    //3. Setter - @Resource

    @Autowired
    CuentaRepository repo;

    //Cliente http, permite consumir endpoints externos
    RestTemplate http = new RestTemplate();

    @Override
    public CuentaResponse crearCuenta(CuentaRequest request) {
        //Los datos son extraidos, acomodados y los faltantes generados por el backend
        //dentro del cuentaMapper
        //Validar: un cliente no debe tener mas de 1 cuenta de cada tipo
        //el otno para aperturar cuenta, debe coincidir con el minimo del tipo
        //de cuenta elegido.
        TipoCuentaRecord record = http.getForObject("http://host.docker.internal:8090/api/v1/catalogos/tipo-cuenta/by-id/"+ request.getTipoCuentaId(), TipoCuentaRecord.class); //http://localhost:8090/api/v1/catalogos/tipo-cuenta/by-id/"
        Cuenta cuenta = null;
        CuentaResponse response = null;

        if(request.getSaldo()< record.saldoMin()){
            System.out.println("Monto menor al minimo de tipo de cuenta deseado");
            throw new UnderMinimumException(Mensajes.Under_Minimum);
        }else if (repo.getAccountByCustomerAndType(request.getClienteId(),request.getTipoCuentaId()).isPresent()){
            System.out.println("Un cliente no puede tener 2 cuentas del mismo tipo");
            throw new AlreadyExistSameAccountException(Mensajes.ACCOUNT_TYPE_ALREADY_EXIST);
        }else{
            cuenta = CuentaMapper.toEntity(request); //Lit crea una cuenta desde cero //Orientacion a objetos
            //Aqui se guarda el objeto
            repo.save(cuenta);//Se creo el nuevo usuario y se guardo, y es aqui en donse se le asigna
            response = CuentaMapper.toResponse(cuenta);
        }
        return response;
        }

    @Override
    public CuentaResponse buscarCuenta(int cuentaId) {

        //Dame el ID y ve y busca el objeto en la base (el experto es el repository)
        //Busca un opcional (un objeto que envuelve a otro y limita su busqueda)
        // y el get agita el objeto a ver si trae algo dentro
        Optional<Cuenta> cuenta = repo.findById(cuentaId);

        if (cuenta.isPresent()){//si hay una cuenta en su interior
            return CuentaMapper.toResponse(cuenta.get());
        }else {
            throw new NotExistException(Mensajes.NOT_EXIST);
        }
    }

    @Override
    public CuentaResponse buscarCuenta(String numCuenta) {

        Optional<Cuenta> cuenta = repo.findByNumCuenta(numCuenta);

        if (numCuenta.length()!=10){
         throw new BussinessException(Mensajes.INVALID_ACCOUNT_NUMBER);
        } else if (cuenta.isPresent()){
            throw new NotExistException(Mensajes.NOT_EXIST);
        }else {
            return CuentaMapper.toResponse(cuenta.get());
        }
    }


    @Override
    public CuentaResponse actualizarCuenta(CuentaRequest request) {

        //Cuando voy a actualizar algo tengo que poner findbyID
        //Aqui no estamos buscando nada porque no existe
        Cuenta cuenta = repo.findById(request.getCuentaId()).get();

        //Al objeto de la cuenta que ya fui a buscar, lo paso al proceso de actualizacion
        //de datos del mapper, devolviendome el mismo objeto
        //(dado que el cuentaId no se sobreescribio)
        cuenta = CuentaMapper.toUpdateEntity(cuenta,request);
        //Aqui se guarda el objeto en la base de datos, aqui se le asigna un cuentaId

        repo.save(cuenta);

        return CuentaMapper.toResponse(cuenta);
    }

    @Override
    public String eliminar(int cuentaId) {
        repo.deleteById(cuentaId);
        return "Cuenta Eliminada";
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
        return response; //Response es el nombre de la lista en donde se
        // estan quedandon los codigos y nos los recuerdan
    }
}
