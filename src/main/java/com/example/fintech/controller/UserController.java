package com.example.fintech.controller;

import com.example.fintech.dto.LoginDto;
import com.example.fintech.model.User;
import com.example.fintech.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok(service.list());
    }

    @PostMapping
    public ResponseEntity<User> criar(@RequestBody User usuario) {
        User novo = service.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Long id, @RequestBody User usuario) {
        usuario.setId(id);
        User atualizado = service.save(usuario);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("login/{id}")
    public ResponseEntity<User> login(@PathVariable Long id, @RequestBody LoginDto loginDto) {
        User user = this.service.login(id, loginDto.username, loginDto.password);
        return ResponseEntity.ok(user);
    }
}
