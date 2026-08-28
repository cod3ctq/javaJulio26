package com.ms_transacciones.repository;

import com.ms_transacciones.entity.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Integer> {
}
