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

//DAO
@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    //Aquí ya se tiene toda la lógica de consultas(INSERT, SELECT, UPDATE, DELETE)
    //prefabricada, al menos las consultas básicas.
    //Cando se requiera, aquí mismo se agreganlas consultas más complejas
    //usando JPQL: Jva Persistence Query Languaje- Consultas orientadas a objetos

    //      UPDATE Cuenta c SET c.status=:   0   WHERE c.numCuenta=:923392479
    @Transactional //Indica que si falla la consulta, revierta los cambios en automático
    @Modifying //Cualquier consulta que requiere que no sesa un simple SELECT, requiere esta anotación
    @Query("UPDATE Cuenta c SET c.status=:status WHERE c.numCuenta=:numCuenta")
    int actualizarStatus(@Param("status") char status, @Param("numCuenta") String numCuenta);

    //
    @Query("SELECT c FROM Cuenta c WHERE c.status = '1'")
    Optional<List<Cuenta>> getActiveAccounts();

    @Query("SELECT c FROM Cuenta c WHERE c.status = '1' AND c.numCuenta=:numCuenta")
    Optional<Cuenta> findByNumCuenta(@Param("numCuenta") String numCuenta);

    @Query("SELECT c FROM Cuenta c WHERE c.status = '1' AND c.cuentaId=:cuentaId")
    Optional<Cuenta> findActiveById(@Param("cuentaId") int cuentaId);

    @Query("SELECT c FROM Cuenta c WHERE c.clienteId =:clienteId AND c.tipoCuentaId =:tipoId")
    Optional<Cuenta> getAccountsByCustomerAndType(@Param("clienteId") int clienteId, @Param("tipoId") int tipoId);

    //boolean existsByCuentaId(int cuentaId);
}
