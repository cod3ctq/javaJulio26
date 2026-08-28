package com.ms_catalogos.repository;

import com.ms_catalogos.entity.MedioPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedioPagoRepository extends JpaRepository<MedioPago, Integer> {
    @Query("SELECT m FROM MedioPago m WHERE m.descripcion =:descripcion")
    Optional<MedioPago> findByDescripcion(@Param("descripcion") String descripcion);
}
