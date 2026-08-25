package com.ms_transacciones.repository;

import com.ms_transacciones.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {

    @Query("SELECT c FROM Cuenta c WHERE c.cuentaId=:cuentaId AND c.status='1'")
    Optional<Cuenta> findCuentaById(@Param("cuentaId") int cuentaId);

}
