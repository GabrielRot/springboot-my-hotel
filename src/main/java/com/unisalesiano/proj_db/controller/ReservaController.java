package com.unisalesiano.proj_db.controller;

import com.unisalesiano.proj_db.entity.Reserva;
import com.unisalesiano.proj_db.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin( origins = "*")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public List<Reserva> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> salvar(@RequestBody Reserva reserva) {
        Reserva salvo = service.salvar(reserva);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Reserva> salvar(@RequestBody Reserva reserva, @PathVariable Long id) {
        return service.buscarPorId(id)
                .map(obj -> {
                    reserva.setIdReserva(id);
                    return ResponseEntity.ok(service.salvar(reserva));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity.noContent().build();
    }

}
