package com.unisalesiano.proj_db.controller;

import com.unisalesiano.proj_db.entity.HospedesReservados;
import com.unisalesiano.proj_db.service.HospedesReservadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospedes-reservados")
@CrossOrigin(origins = "*")
public class HospedesReservadosController {

    @Autowired
    private HospedesReservadosService service;

    @GetMapping
    public List<HospedesReservados> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("{id}/hospedes")
    public ResponseEntity<List<HospedesReservados>> listarHospdesReservados(@PathVariable Long id) {
        List<HospedesReservados> result = service.buscarHospedesReservadosPorReserva(id);

        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<HospedesReservados> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HospedesReservados> salvar(@RequestBody HospedesReservados hospedesReservados) {
        HospedesReservados salvar = service.salvar(hospedesReservados);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @PutMapping("{id}")
    public ResponseEntity<HospedesReservados> salvar(@RequestBody HospedesReservados hospedesReservados, @PathVariable Long id) {
        return service.buscarPorId(id)
                .map(obj -> {
                    hospedesReservados.setIdHospedeReservado(id);

                    return ResponseEntity.ok(service.salvar(hospedesReservados));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> excluir(@RequestBody List<Long> ids) {
        ids.forEach(service::excluir);

        return ResponseEntity.noContent().build();
    }

}
