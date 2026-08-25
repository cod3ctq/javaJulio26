package com.ms_tarjetas.repository;

import com.ms_tarjetas.entity.Tarjeta;
import com.ms_tarjetas.entity.TipoTarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {

    @Query(value = "SELECT t FROM Tarjeta t WHERE t.numTarjeta=:numTarjeta AND t.status='ACTIVO'")
    Optional<Tarjeta> findByNumTarjeta(@Param("numTarjeta") String numTarjeta);

    @Query(value = "SELECT t FROM Tarjeta t WHERE t.cuentaId=:cuentaId")
    Optional<Tarjeta> hasCard(@Param("cuentaId") Integer cuentaId);

    @Query(value = "SELECT tt FROM TipoTarjeta tt WHERE tt.tipoTarjetaId=:tipoTarjetaId")
    Optional<TipoTarjeta> getTipoTarjetaById(@Param("tipoTarjetaId") int tipoTarjetaId);

}
