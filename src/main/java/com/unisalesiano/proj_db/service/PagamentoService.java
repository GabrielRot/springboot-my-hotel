package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.Pagamento;

import java.util.List;
import java.util.Optional;

public interface PagamentoService {

    List<Pagamento> listarTodos();

    Optional<Pagamento> buscarPorId(Long id);

    Pagamento salvar(Pagamento pagamento);

    void excluir(Long id);

}
