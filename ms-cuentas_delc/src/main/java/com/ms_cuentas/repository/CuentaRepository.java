package com.ms_cuentas.repository;

import com.ms_cuentas.entity.Cuenta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//DAO
@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    //Aquí ya se tiene toda la lógica de consultas (INSERT, SELECT, UPDATE, DELETE)
    //Prefabricada, al menos las consultas básicas.
    //Cuando se requiera, aquí mismo se agregan las consultas complejas
    //usando JPQL: Java Persistence Query Lenguaje - Consultas orientadas a objetos

    //Todos los medotos se implementan directamente en Postman mediante los prefijos GET, POST, PUT, DELETE

    // UPDATE cuenta c SET c.status=: 0 WHERE c.numCuenta=: 923392479
    @Transactional //Indica que si falla la consulta revierta los cambios en automatico
    @Modifying // Cualquier consulta que no sea un simple SELECT, requiere esta anotacion
    @Query("UPDATE Cuenta c SET c.status=:status WHERE c.numCuenta=:numCuenta")
    int actualizarStatus(@Param("status") char status,@Param("numCuenta") String numCuenta);


    //Es una lectura simple, por esa razon no lleva los Transactional
    @Query("SELECT c FROM Cuenta c WHERE c.status = '1' ")
    Optional<List<Cuenta>> getActiveAccounts();

    @Query("SELECT c FROM Cuenta c WHERE TRIM(c.status) = '1' AND c.numCuenta=:numCuenta")
    Optional<Cuenta> findByNumCuenta(@Param("numCuenta")String numCuenta);

    @Query("SELECT c FROM Cuenta c WHERE c.status = '1' AND c.cuentaId=:cuentaId")
    Optional<Cuenta> findActiveById(@Param("cuentaId") int cuentaId);

    @Query("SELECT c FROM Cuenta c WHERE c.clienteId =:clienteId AND c.tipoCuentaId =:tipoId")
    Optional<Cuenta> getAccountByCustomerAndType(@Param("clienteId") int clienteId,
                                                 @Param("tipoId") int tipoId);



}
