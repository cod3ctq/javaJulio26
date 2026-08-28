package com.ms_catalogos.repository;

import com.ms_catalogos.entity.TipoCuenta;
import com.ms_catalogos.entity.TipoTarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoTarjetaRepository extends JpaRepository<TipoTarjeta, Integer> {

    @Query("SELECT tt FROM TipoTarjeta tt WHERE tt.descripcion =:descripcion")
    Optional<TipoCuenta> findByDescripcion(@Param("descripcion")String descripcion);



}
