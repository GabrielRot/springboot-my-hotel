package com.unisalesiano.proj_db.controller;

import com.unisalesiano.proj_db.entity.TipoQuarto;
import com.unisalesiano.proj_db.service.TipoQuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-quarto")
@CrossOrigin(origins = "*")
public class TipoQuartoController {

    @Autowired
    private TipoQuartoService service;

    @GetMapping
    public List<TipoQuarto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoQuarto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoQuarto> salvar(@RequestBody TipoQuarto tipoQuarto) {
        TipoQuarto salvo = service.salvar(tipoQuarto);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoQuarto> atualizar(@PathVariable Long id, @RequestBody TipoQuarto tipoQuarto) {
        return service.buscarPorId(id)
                .map(objExistente -> {
                    tipoQuarto.setIdTipoQuarto(id); // Garante que esteja atualizando o registro certo
                    return ResponseEntity.ok(service.salvar(tipoQuarto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

}
