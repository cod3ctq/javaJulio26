package com.ms_prestamos.repository;

import com.ms_prestamos.entity.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrestamosRepository extends JpaRepository<Prestamos, Integer> {

    //SELECT P.CLIENTE_ID, C.NUM_CUENTA, P.MONTO, C.SALDO
    //FROM PRESTAMOS P
    //INNER JOIN CUENTAS C
    //ON C.CLIENTE_ID = P.CLIENTE_ID;
    //SELECT * FROM WV_SERVICIOS_RECIBOS
//    @Query("SELECT * FROM WV_PRESTAMO_CUENTA")
//    Optional<Prestamos> getAmountAccount();

}
