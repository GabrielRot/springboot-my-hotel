package com.unisalesiano.proj_db.repository;

import com.unisalesiano.proj_db.entity.HospedesReservados;
import com.unisalesiano.proj_db.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {



}
