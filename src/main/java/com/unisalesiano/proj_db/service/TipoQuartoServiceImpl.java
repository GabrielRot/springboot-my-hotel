package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.TipoQuarto;
import com.unisalesiano.proj_db.repository.TipoQuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoQuartoServiceImpl implements TipoQuartoService {

    @Autowired
    private TipoQuartoRepository repository;

    @Override
    public List<TipoQuarto> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<TipoQuarto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public TipoQuarto salvar(TipoQuarto tipoQuarto) {
        return repository.save(tipoQuarto);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
