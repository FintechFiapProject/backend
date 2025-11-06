package com.example.fintech.controller;

import com.example.fintech.model.Meta;
import com.example.fintech.service.MetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metas")
public class MetaController {

    private final MetaService service;

    public MetaController(MetaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Meta>> listar() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> buscarPorId(@PathVariable String id) {
        Optional<Meta> meta = service.find(id);
        return (meta != null) ? ResponseEntity.ok(meta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Meta> criar(@RequestBody Meta meta) {
        Meta nova = service.save(meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meta> atualizar(@PathVariable String id, @RequestBody Meta meta) {
        Meta atualizada = service.update(id, meta);
        return (atualizada != null) ? ResponseEntity.ok(atualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}
