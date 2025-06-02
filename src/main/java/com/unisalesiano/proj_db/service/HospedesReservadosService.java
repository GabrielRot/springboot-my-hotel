package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.HospedesReservados;

import java.util.List;
import java.util.Optional;

public interface HospedesReservadosService {

    List<HospedesReservados> listarTodos();

    List<HospedesReservados> buscarHospedesReservadosPorReserva(Long idReserva);

    Optional<HospedesReservados> buscarPorId(Long id);

    HospedesReservados salvar(HospedesReservados hospedesReservados);

    void excluir(Long id);

}
