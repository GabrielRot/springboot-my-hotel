package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.Pagamento;
import com.unisalesiano.proj_db.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Override
    public List<Pagamento> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Pagamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Pagamento salvar(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

}
