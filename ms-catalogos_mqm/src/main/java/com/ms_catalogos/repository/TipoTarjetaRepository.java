package com.ms_catalogos.repository;

import com.ms_catalogos.entity.TipoTarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTarjetaRepository extends JpaRepository<TipoTarjeta, Integer> {

}
