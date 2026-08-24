package com.ms_cuentas.repository;

import com.ms_cuentas.entity.Cuenta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.deser.std.FromStringWithRadixToNumberDeserializer;

import java.util.List;
import java.util.Optional;

//DAO
@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    //Aqui ya se tienen toda la logica de consultas (INSERT, SELECT, UPDATE, DELETE)
    //Prefabricada, al menos las consultas basicas.
    //Cuando se requiera, aqui mismo se agregaran las consultas mas complejas
    //usando JOQL : Java Persistence Query Languaje - Consultas orienatadas a objetos.


    //      UPDATE CUENTA c SET c.status=: 0     WHERE c.numCuenta=:923392479
    @Transactional //Indica que si falla la consulta, revierta los cambios en automatico no
    @Modifying //Cualquier consulta que no sea un simple SELECT, requiere esta anotacion
    @Query("UPDATE Cuenta c SET c.status=:status WHERE c.numCuenta=:numCuenta") //Es en nombre de la clase
    int actualizarStatus(@Param("status") char status, @Param("numCuenta") String numCuenta); //Metodoabstracto
    
    @Query("SELECT c FROM Cuenta c WHERE c.status = '1'")
    Optional<List<Cuenta>> getActiveAccounts();

    @Query("SELECT c FROM Cuenta c WHERE c.status = '1' AND c.numCuenta=:cuentaId")
    Optional<Cuenta> findActiveById(@Param("cuentaId") int cuentaId);

    @Query("SELECT c FROM Cuenta c WHERE c.clienteId =:clienteId AND c.tipoCuentaId =:tipoId")
    Optional<Cuenta> getAccountByCustomerAndType(@Param("clienteID") int clienteId,
                                                @Param("tipoId") int tipoId);


    Optional<Cuenta> findByNumCuenta(String numCuenta);
}
