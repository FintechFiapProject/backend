package com.fintech.controller;

import com.fintech.model.Meta;
import com.fintech.service.MetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {

    private final MetaService service;

    public MetaController(MetaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Meta>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meta> buscarPorId(@PathVariable Long id) {
        Meta meta = service.buscarPorId(id);
        return (meta != null) ? ResponseEntity.ok(meta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Meta> criar(@RequestBody Meta meta) {
        Meta nova = service.salvar(meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meta> atualizar(@PathVariable Long id, @RequestBody Meta meta) {
        Meta atualizada = service.atualizar(id, meta);
        return (atualizada != null) ? ResponseEntity.ok(atualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
