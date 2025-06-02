package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.ServicosRealizados;

import java.util.List;
import java.util.Optional;

public interface ServicosRealizadosService {

    List<ServicosRealizados> listarTodos();

    List<ServicosRealizados> buscarServicosRealizadosPorReserva(Long idReserva);

    Optional<ServicosRealizados> buscarPorId(Long id);

    ServicosRealizados salvar(ServicosRealizados servicosRealizados);

    void excluir(Long id);

}
