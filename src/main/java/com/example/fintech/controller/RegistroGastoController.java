package com.fintech.controller;

import com.fintech.model.RegistroGasto;
import com.fintech.service.RegistroGastoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroGastoController {

    private final RegistroGastoService service;

    public RegistroGastoController(RegistroGastoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RegistroGasto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroGasto> buscarPorId(@PathVariable Long id) {
        RegistroGasto registro = service.buscarPorId(id);
        return (registro != null) ? ResponseEntity.ok(registro) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RegistroGasto> criar(@RequestBody RegistroGasto registro) {
        RegistroGasto novo = service.salvar(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroGasto> atualizar(@PathVariable Long id, @RequestBody RegistroGasto registro) {
        RegistroGasto atualizado = service.atualizar(id, registro);
        return (atualizado != null) ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
