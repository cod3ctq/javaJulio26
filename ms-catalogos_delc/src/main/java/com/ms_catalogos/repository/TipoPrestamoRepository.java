package com.ms_catalogos.repository;


import com.ms_catalogos.entity.TipoPrestamo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPrestamoRepository extends JpaRepository<TipoPrestamo,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE TipoPrestamo tp SET tp.interes =:interes WHERE tp.tipoPrestamoId =:id")
    int updateInteres(@Param("id") Integer id, @Param("interes") double interes);

}
