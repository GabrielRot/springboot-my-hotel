package com.unisalesiano.proj_db.controller;

import com.unisalesiano.proj_db.entity.Pagamento;
import com.unisalesiano.proj_db.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
@CrossOrigin(origins = "*")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping()
    public List<Pagamento> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento) {
        Pagamento salvo = service.salvar(pagamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento, @PathVariable Long id) {
        return service.buscarPorId(id)
                .map(obj -> {
                    pagamento.setIdPagamento(id);

                    return ResponseEntity.ok(service.salvar(pagamento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> salvar(@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity.noContent().build();
    }

}
