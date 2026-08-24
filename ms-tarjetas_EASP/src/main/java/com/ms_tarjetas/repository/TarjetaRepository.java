package com.ms_tarjetas.repository;

import com.ms_tarjetas.entity.Tarjeta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Tarjeta t SET t.status = :status WHERE t.numTarjeta =:numTarjeta")
    int actualizarStatus (@Param("status") char status, @Param("numTarjeta") String numTarjeta);

    @Query("SELECT t FROM Tarjeta t WHERE t.status = 'ACTIVA' AND t.numCuenta =:numTarjeta")
    Optional<Tarjeta> findByNumTarjeta(@Param ("numTarjeta") String numTarjeta);

    @Query("SELECT t FROM Tarjeta t WHERE t.cuentaId =:cuentaId")
    Optional<Tarjeta> getCardByAccount (@Param("cuentaId") int cuentaId);

    @Query("SELECT t FROM Tarjeta t WHERE t.status = 'ACTIVA' AND t.tarjetaId =:tarjetaId")
    Optional<Tarjeta> findByActiveCards(@Param ("tarjetaId") int tarjetaId);

}
