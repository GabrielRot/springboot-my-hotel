package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.TipoQuarto;

import java.util.List;
import java.util.Optional;

public interface TipoQuartoService {

    List<TipoQuarto> listarTodos();

    Optional<TipoQuarto> buscarPorId(Long id);

    TipoQuarto salvar(TipoQuarto tipoQuarto);

    void deletar(Long id);

}
