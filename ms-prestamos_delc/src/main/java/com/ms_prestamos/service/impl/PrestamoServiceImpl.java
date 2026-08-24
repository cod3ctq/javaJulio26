package com.ms_prestamos.service.impl;


import com.ms_prestamos.constants.Mensajes;
import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.entity.Prestamo;
import com.ms_prestamos.exception.BusinessException;
import com.ms_prestamos.mapper.PrestamoMapper;
import com.ms_prestamos.repository.PrestamoRepository;
import com.ms_prestamos.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository repo;

    @Override
    public List<PrestamoResponse> mostrar() {
        List<Prestamo> prestamos = repo.findAll();
        if (prestamos.isEmpty()){
            throw new BusinessException.NotExistException(Mensajes.NOT_LOAN_EXIST);
        }

        return prestamos.stream().map(PrestamoMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public PrestamoResponse buscarPorId(int prestamoId) {
        Prestamo prestamo = repo.findById(prestamoId).orElseThrow(()-> new BusinessException.LoanIdNotExistException(Mensajes.LOAN_ID_NOT_EXIST));
    return PrestamoMapper.toResponse(prestamo);
    }

    @Override
    public PrestamoResponse crearPrestamo(PrestamoRequest request) {
        if (request.getMonto() <=0 ){
            throw new BusinessException(Mensajes.INVALID_LOAN);
        }
        Prestamo prestamo = PrestamoMapper.toEntity(request);

        prestamo.setFecha(LocalDate.now());
        prestamo.setFechaFin(LocalDate.now().plusYears(100));

        Prestamo prestamoGuardado = repo.save(prestamo);

        return PrestamoMapper.toResponse(prestamoGuardado);
    }

    @Override
    public List<PrestamoResponse> buscarPorCliente(int clienteId) {
        List<Prestamo> prestamos = repo.findByClienteId(clienteId);
        if (prestamos.isEmpty()){
            throw new BusinessException(Mensajes.NOT_EXIST);
        }

        return prestamos.stream().map(PrestamoMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public PrestamoResponse abonarAPrestamo(int prestamoId, double montoAbono) {
        if (montoAbono <=0){
            throw new BusinessException(Mensajes.INVALID_PAYMENT);
        }
        Prestamo prestamo = repo.findById(prestamoId)
                .orElseThrow(() -> new BusinessException(Mensajes.LOAN_ID_NOT_EXIST));

        double nuevoRestante = prestamo.getRestante() - montoAbono;

        if (nuevoRestante <0){
            throw new BusinessException(Mensajes.REMAINING_OVERPAYMENT);
        }
        prestamo.setRestante(nuevoRestante);
        return PrestamoMapper.toResponse(prestamo);
    }
}
