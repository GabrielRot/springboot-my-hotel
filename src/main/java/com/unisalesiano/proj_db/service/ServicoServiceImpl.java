package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.Servico;
import com.unisalesiano.proj_db.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository repository;

    @Override
    public List<Servico> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Servico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Servico salvar(Servico servico) {
        return repository.save(servico);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
