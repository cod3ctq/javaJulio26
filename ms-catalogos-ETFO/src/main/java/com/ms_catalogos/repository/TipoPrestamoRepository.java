package com.ms_catalogos.repository;

import com.ms_catalogos.entity.TipoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPrestamoRepository extends JpaRepository<TipoPrestamo,Integer> {
}
