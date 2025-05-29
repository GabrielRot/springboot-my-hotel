package com.unisalesiano.proj_db.controller;

import com.unisalesiano.proj_db.entity.Hospede;
import com.unisalesiano.proj_db.service.HospedeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospede")
@CrossOrigin(origins = "*")
public class HospedeController {

    @Autowired
    HospedeService service;

    @GetMapping
    public List<Hospede> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Hospede> salvar(@RequestBody Hospede hospede) {
        return ResponseEntity.ok(service.salvar(hospede));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospede> atualizar(@PathVariable Long id, @RequestBody Hospede hospede) {
        return service.buscarPorId(id)
                    .map(objExistente -> {
                        hospede.setIdHospede(id);

                        return ResponseEntity.ok(service.salvar(hospede));
                    })
                    .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<Void> remover(@RequestBody List<Long> idsHospedes) {
        idsHospedes.forEach(service::deletar);

        return ResponseEntity.ok().build();
    }
}
