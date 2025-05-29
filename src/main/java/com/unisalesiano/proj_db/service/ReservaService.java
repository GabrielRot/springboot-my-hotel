package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    List<Reserva> listarTodos();

    Optional<Reserva> buscarPorId(Long id);

    Reserva salvar(Reserva reserva);

    void excluir(Long id);

}
