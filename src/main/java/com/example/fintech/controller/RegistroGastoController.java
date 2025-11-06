package com.example.fintech.controller;

import com.example.fintech.model.RegistroGasto;
import com.example.fintech.service.RegistroGastoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registros")
public class RegistroGastoController {

    private final RegistroGastoService service;

    public RegistroGastoController(RegistroGastoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RegistroGasto>> listar() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> buscarPorId(@PathVariable Long id) {
        Optional<RegistroGasto> registro = service.find(id);
        return (registro != null) ? ResponseEntity.ok(registro) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RegistroGasto> criar(@RequestBody RegistroGasto registro) {
        RegistroGasto novo = service.save(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroGasto> atualizar(@PathVariable Long id, @RequestBody RegistroGasto registro) {
        RegistroGasto atualizado = service.update(id, registro);
        return (atualizado != null) ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
