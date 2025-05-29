package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.Reserva;
import com.unisalesiano.proj_db.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Override
    public List<Reserva> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Reserva salvar(Reserva reserva) {
        return repository.save(reserva);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

}
