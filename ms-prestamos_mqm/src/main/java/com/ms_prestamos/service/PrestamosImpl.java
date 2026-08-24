package com.ms_prestamos.service;

import com.ms_prestamos.constants.Mensajes;
import com.ms_prestamos.dto.CuentaRecord;
import com.ms_prestamos.dto.PrestamosRequest;
import com.ms_prestamos.dto.PrestamosResponse;
import com.ms_prestamos.entity.Prestamos;
import com.ms_prestamos.exception.BussinessException;
import com.ms_prestamos.mapper.PrestamosMapper;
import com.ms_prestamos.repository.PrestamosRepository;
import com.ms_prestamos.util.PrestamosHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamosImpl implements PrestamosService{

    @Autowired
    PrestamosRepository repo;

    RestTemplate http = new RestTemplate();

    @Override
    public PrestamosResponse crearPrestamo(PrestamosRequest request) {

        CuentaRecord record = http.getForObject(
                "http://localhost:8090/api/v1/cuentas/",
                CuentaRecord.class);

        Prestamos prestamo = null;

        //Validar que la cantidad solicitada del prestamo
        // sea menor o igual al 60% del saldo de la cuenta
        double cantidad = (record.saldo())*.60;

        if (request.getMonto()<=cantidad){
            throw new BussinessException(Mensajes.LOW_BALANCE_THRESHOLD_EXCEPTION);
        }else {
            prestamo = PrestamosMapper.toEntity(request);
            repo.save(prestamo);
        }
        return PrestamosMapper.toResponse(prestamo);
    }

    @Override
    public PrestamosResponse buscarPrestamo(int prestamoId) {

        Optional<Prestamos> prestamo = repo.findById(prestamoId);

        if (prestamo.isPresent()){
            return PrestamosMapper.toResponse(prestamo.get());
        }else {
            throw new BussinessException(Mensajes.ID_LOAN_NOT_FOUND_EXCEPTION);
        }

    }

    @Override
    public PrestamosResponse actualizarPrestamo(PrestamosRequest request) {

        Prestamos prestamo = repo.findById(request.getPrestamoId()).get();

        prestamo=PrestamosMapper.toUpdateEntity(prestamo, request);

        repo.save(prestamo);

        return PrestamosMapper.toResponse(prestamo);
    }

    @Override
    public String eliminar(int prestamoId) {
        repo.deleteById(prestamoId);
        return "Prestamo elimidado";
    }

    @Override
    public List mostrar() {
        List<PrestamosResponse> response = new ArrayList<PrestamosResponse>();
        for (Prestamos p : repo.findAll()){
            response.add(PrestamosMapper.toResponse(p));
        }
        return response;
    }
}
