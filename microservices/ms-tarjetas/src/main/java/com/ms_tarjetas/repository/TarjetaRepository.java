package com.ms_tarjetas.repository;

import com.ms_tarjetas.entity.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{

    @Transactional //Indica que si falla la consulta, revierta los cambios en automático
    @Modifying //Cualquier consulta que requiere que no sesa un simple SELECT, requiere esta anotación
    @Query("UPDATE Tarjeta t SET t.status=:status WHERE t.numTarjeta=:numTarjeta")
    int actualizarStatus(@Param("status") String status, @Param("numCuenta") String numCuenta);

    @Query("SELECT t FROM Tarjeta t WHERE t.status = 'ACTIVO'")
    Optional<List<Tarjeta>> getActiveAccounts();

    @Query("SELECT t FROM Tarjeta t WHERE t.status = 'ACTIVO' AND t.numTarjeta=:numTarjeta")
    Optional<Tarjeta> findByNumTarjeta(@Param("numTarjeta") String numTarjeta);

    @Query("SELECT t FROM Tarjeta t WHERE t.status = 'ACTIVO' AND t.tarjetaId=:tarjetaId")
    Optional<Tarjeta> findActiveById(@Param("tarjetaId") int tarjetaId);

    @Query("SELECT t FROM Tarjeta t ")
    Optional<List<Tarjeta>> getAllCards(@Param("cuentaId") int cuentaId);
}
