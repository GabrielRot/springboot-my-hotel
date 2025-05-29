package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.Hospede;
import com.unisalesiano.proj_db.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeServiceImpl implements HospedeService {

    @Autowired
    private HospedeRepository repository;

    @Override
    public List<Hospede> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Hospede> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Hospede salvar(Hospede hospede) {
        return repository.save(hospede);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
