package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.Quarto;

import java.util.List;
import java.util.Optional;

public interface QuartoService {

    List<Quarto> listarTodos();

    Optional<Quarto> buscarPorId(Long id);

    Quarto salvar(Quarto quarto);

    void deletar(Long id);

}
