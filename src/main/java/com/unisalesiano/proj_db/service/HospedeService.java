package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.Hospede;

import java.util.List;
import java.util.Optional;

public interface HospedeService {

    List<Hospede> listarTodos();

    Optional<Hospede> buscarPorId(Long id);

    Hospede salvar(Hospede hospede);

    void deletar(Long id);

}
