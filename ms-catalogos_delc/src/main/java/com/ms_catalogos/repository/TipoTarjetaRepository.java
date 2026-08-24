package com.ms_catalogos.repository;

import com.ms_catalogos.entity.TipoTarjeta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTarjetaRepository extends JpaRepository<TipoTarjeta,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE TipoTarjeta tt SET tt.descripcion =:descripcion WHERE tt.tipoTId =:id")
    int updateTipoTarjeta(@Param("id") Integer id,@Param("descripcion") String descripcion);
}
