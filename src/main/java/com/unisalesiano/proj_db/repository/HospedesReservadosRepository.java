package com.unisalesiano.proj_db.repository;

import com.unisalesiano.proj_db.entity.Hospede;
import com.unisalesiano.proj_db.entity.HospedesReservados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospedesReservadosRepository extends JpaRepository <HospedesReservados, Long> {

    @Query("SELECT hr FROM HospedesReservados hr JOIN FETCH hr.hospede WHERE hr.reserva.idReserva = :idReserva")
    List<HospedesReservados> findByReservaIdWithHospedes(@Param("idReserva") Long idReserva);

}
