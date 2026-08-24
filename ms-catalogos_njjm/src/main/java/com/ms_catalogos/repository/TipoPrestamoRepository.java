package com.ms_catalogos.repository;

import com.ms_catalogos.entity.TipoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoPrestamoRepository extends JpaRepository<TipoPrestamo, Integer> {
    @Query("SELECT tp FROM TipoPrestamo tp WHERE tp.descripcion=:descripcion")
    Optional<TipoPrestamo> findByDescripcion(@Param("descripcion")String descripcion);
}
