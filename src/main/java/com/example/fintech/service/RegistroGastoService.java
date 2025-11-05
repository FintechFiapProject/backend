package com.example.fintech.service;

import com.example.fintech.model.RegistroGasto;
import com.example.fintech.model.User;
import com.example.fintech.repository.RegistroGastoRepository;
import com.example.fintech.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroGastoService {
    private final RegistroGastoRepository repository;

    public RegistroGastoService(RegistroGastoRepository registroGastoRepository) {
        this.repository = registroGastoRepository;
    }

    public List<RegistroGasto> list() {
        return repository.findAll();
    }

    public Optional<RegistroGasto> find(String id) {
        return repository.findById(id);
    }

    public RegistroGasto save(RegistroGasto registroGasto) {
        return repository.save(registroGasto);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
