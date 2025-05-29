package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.Quarto;
import com.unisalesiano.proj_db.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoServiceImpl implements QuartoService {

    @Autowired
    private QuartoRepository repository;

    @Override
    public List<Quarto> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Quarto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Quarto salvar(Quarto quarto) {
        return repository.save(quarto);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
