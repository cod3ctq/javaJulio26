package com.ms_prestamos.repository;

import com.ms_prestamos.entity.Prestamo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,Integer> {

    List<Prestamo> findByClienteId(int clienteId);

    @Modifying
    @Transactional
    @Query("UPDATE Prestamo p SET p.restante =:nuevoRestante WHERE p.prestamoId =:id")
    int updateSaldoRestante(@Param("id") int id, @Param("nuevoRestante") double nuevoRestante);


}
