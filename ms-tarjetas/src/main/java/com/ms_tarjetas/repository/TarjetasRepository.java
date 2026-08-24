package com.ms_tarjetas.repository;


import com.ms_tarjetas.entity.Tarjetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetasRepository extends JpaRepository<Tarjetas, Integer> {

}
