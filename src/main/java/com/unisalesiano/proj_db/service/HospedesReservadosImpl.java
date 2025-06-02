package com.unisalesiano.proj_db.service;

import com.unisalesiano.proj_db.entity.HospedesReservados;
import com.unisalesiano.proj_db.repository.HospedesReservadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedesReservadosImpl implements HospedesReservadosService {

    @Autowired
    private HospedesReservadosRepository repository;

    @Override
    public List<HospedesReservados> buscarHospedesReservadosPorReserva(Long idReserva) {
        return repository.findByReservaIdWithHospedes(idReserva);
    }

    @Override
    public List<HospedesReservados> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<HospedesReservados> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public HospedesReservados salvar(HospedesReservados hospedesReservados) {
        return repository.save(hospedesReservados);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }

}
