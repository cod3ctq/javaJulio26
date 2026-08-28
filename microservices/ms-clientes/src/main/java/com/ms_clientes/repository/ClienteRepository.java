package com.ms_clientes.repository;

import com.ms_clientes.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {

    //Buscar al cliente basado en el RFC
    @Query("SELECT c FROM Clientes c WHERE c.rfc=:rfc")
    Optional<Clientes> findByRfc(@Param("rfc") String rfc);

    @Query("SELECT c FROM Clientes c WHERE c.telefono=:telefono")
    Optional<Clientes> findByTelefono(@Param("telefono") String telefono);

    @Query("SELECT c FROM Clientes c WHERE c.correo=:correo")
    Optional<Clientes> findByCorreo(@Param("correo") String correo);

    @Query("SELECT c FROM Clientes c WHERE c.direccion=:direccion")
    Optional<Clientes> findByDireccion(@Param("direccion") String direccion);

    @Query("SELECT c FROM Clientes c WHERE c.ine=:ine")
    Optional<Clientes> findByIne(@Param("ine") String ine);

    @Query("SELECT c FROM Clientes c WHERE c.nombre=:nombre AND c.apP=:pat AND c.apM=:mat")
    Optional<Clientes> findByNombreCompleto(@Param("ine") String nombre,
                                            @Param("pat") String pat,
                                            @Param("mat") String mat);

    @Modifying
    @Query("UPDATE Clientes c SET c.status = 0 WHERE c.ine=:ine")
    int deleteByIne(@Param("ine") String ine);

    @Query("SELECT c FROM Clientes c WHERE c.status = 1")
    List<Clientes> findAllActives();



}
