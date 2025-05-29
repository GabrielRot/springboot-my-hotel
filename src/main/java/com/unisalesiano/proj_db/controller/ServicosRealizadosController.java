package com.unisalesiano.proj_db.controller;

import com.unisalesiano.proj_db.entity.ServicosRealizados;
import com.unisalesiano.proj_db.service.ServicosRealizadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos-realizados")
@CrossOrigin(origins = "*")
public class ServicosRealizadosController {

    @Autowired
    ServicosRealizadosService service;

    @GetMapping
    public List<ServicosRealizados> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("{id}")
    public ResponseEntity<ServicosRealizados> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServicosRealizados> salvar(@RequestBody ServicosRealizados servicosRealizados) {
        ServicosRealizados salvo = service.salvar(servicosRealizados);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);

        //return ResponseEntity.ok(service.salvar(servicosRealizados));
    }

    @PutMapping("{id}")
    public ResponseEntity<ServicosRealizados> salvar(@RequestBody ServicosRealizados servicosRealizados, @PathVariable Long id) {
        return service.buscarPorId(id)
                .map(obj -> {
                    servicosRealizados.setIdServRealizado(id);

                    return ResponseEntity.ok(service.salvar(servicosRealizados));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity.noContent().build();
    }

}
