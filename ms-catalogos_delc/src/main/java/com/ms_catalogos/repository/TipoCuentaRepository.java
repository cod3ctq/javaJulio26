package com.ms_catalogos.repository;

import com.ms_catalogos.entity.TipoCuenta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Integer> {

    @Query("SELECT tc FROM TipoCuenta tc WHERE tc.descripcion=:descripcion")
    Optional<TipoCuenta> findByDescripcion(@Param("descripcion")String descripcion);



}
