package com.unisalesiano.proj_db.controller;

import com.unisalesiano.proj_db.entity.Quarto;
import com.unisalesiano.proj_db.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quarto")
@CrossOrigin(origins = "*")
public class QuartoController {

    @Autowired
    private QuartoService service;

    @GetMapping
    public List<Quarto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> buscarPorId(@PathVariable Long id) {
      return service.buscarPorId(id)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Quarto> salvar(@RequestBody Quarto quarto) {
        Quarto salvo = service.salvar(quarto);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Quarto> salvar(@PathVariable Long id, @RequestBody Quarto quarto) {
        return service.buscarPorId(id)
                .map(objExistente -> {
                    quarto.setIdQuarto(id);

                    return ResponseEntity.ok(service.salvar(quarto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@RequestBody List<Long> idsQuartos) {
        idsQuartos.forEach(service::deletar);

        return ResponseEntity.noContent().build();
    }

}
