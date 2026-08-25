package com.example.ms_transacciones.repository;

import com.example.ms_transacciones.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento,Integer> {
}
