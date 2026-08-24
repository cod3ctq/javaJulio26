package com.ms_cuentas.repository;

import com.ms_cuentas.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {
    //Aquí ya se tiene toda la logica de consultas (INSERT, SELECT, UPDATE, DELETE)
    //prefabricada, al menos las consultas basicas
    // Cuando se requiera, aquí mismo se agregaron las consultas más complejas
    //usando JPQL : Java Persistence Query Languaje - Consultas orientadas a objetos
    //UPDATE Cuenta c SET c.status=:0 WHERE c.numCuenta=:923392479
    //@Query(value = "UPDATE CUENTAS SET STATUS =:status WHERE NUM_CUENTA =:numCuenta", nativeQuery = true)
    @Transactional //Indica que si falla la consulta, revierta los cambios en automatico
    @Modifying //Cualquier consulta que no sea un simple SELECT, requiere esta anotacion
    @Query(value = "UPDATE Cuenta c SET status=:status WHERE numCuenta=:numCuenta")
    int actualizarStatus(@Param("status") char status,@Param("numCuenta") String numCuenta);

    //El opcional es similar a preguntar ¿Hay algo aqui?, es util para aquellas coas que no existan
    @Query(value = "SELECT c FROM Cuenta c WHERE c.status='1'")
    Optional<List<Cuenta>> getActivateAccounts();

    @Query("SELECT c FROM Cuenta c WHERE c.status = '1' AND c.numCuenta =:numCuenta")
    Optional<Cuenta> findByNumCuenta(@Param("numCuenta") String numCuenta);

    @Query("SELECT c FROM Cuenta c WHERE c.clienteId =:clienteId AND c.tipoCuentaId=:tipoId")
    Optional<Cuenta> getAccountByCustomerAndType(
            @Param("clienteId") int clienteId,
            @Param("tipoId") int tipoId
    );

    @Query("SELECT c FROM Cuenta c WHERE c.cuentaId=:cuentaId AND c.status='1'")
    Optional<Cuenta> findActiveByCuentaId(@Param("cuentaId") int cuentaId);

}
