package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.ServicosRealizados;
import com.unisalesiano.proj_db.repository.ServicosRealizadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicosRealizadosImpl implements ServicosRealizadosService {

    @Autowired
    private ServicosRealizadosRepository repository;

    @Override
    public List<ServicosRealizados> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<ServicosRealizados> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public ServicosRealizados salvar(ServicosRealizados servicosRealizados) {
        return repository.save(servicosRealizados);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }


}
