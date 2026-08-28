package com.ms_catalogos.repository;

import com.ms_catalogos.entity.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta,Integer> {

    @Query("SELECT tc FROM TipoCuenta tc WHERE tc.descripcionTipoCuenta=:descripcion")
    Optional<TipoCuenta> findByDescripcionTipoCuenta(@Param("descripcion") String descripcion);

    //actualizarSaldoMin(String descripcion, double saldo)
    @Query("UPDATE TipoCuenta tc SET tc.saldoMin=:saldoMin WHERE tc.descripcionTipoCuenta=:descripcion")
    int actualizarSaldoMin(@Param("saldoMin") double saldoMin, @Param("descripcion") String descripcion);
}
