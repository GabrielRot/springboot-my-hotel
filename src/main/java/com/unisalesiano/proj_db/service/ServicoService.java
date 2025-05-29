package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.Servico;

import java.util.List;
import java.util.Optional;

public interface ServicoService {

    List<Servico> listarTodos();

    Optional<Servico> buscarPorId(Long id);

    Servico salvar(Servico servico);

    void deletar(Long id);

}
