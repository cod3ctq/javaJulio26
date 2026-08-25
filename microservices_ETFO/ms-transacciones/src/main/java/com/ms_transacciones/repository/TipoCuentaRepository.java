package com.ms_transacciones.repository;

import com.ms_transacciones.entity.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Integer> {

    @Query("SELECT tc FROM TipoCuenta tc WHERE tc.tipoCuentaId=:tipoCuentaId")
    Optional<TipoCuenta> findTipoCuentaById(@Param("tipoCuentaId") int tipoCuentaId);

}
