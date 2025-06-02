package com.unisalesiano.proj_db.repository;

import com.unisalesiano.proj_db.entity.ServicosRealizados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicosRealizadosRepository extends JpaRepository<ServicosRealizados, Long> {

  @Query("SELECT sr FROM ServicosRealizados sr JOIN FETCH sr.servico WHERE sr.reserva.idReserva = :idReserva")
    List<ServicosRealizados> findReservaIdWithServicos(@Param("idReserva") Long idReserva);
}
