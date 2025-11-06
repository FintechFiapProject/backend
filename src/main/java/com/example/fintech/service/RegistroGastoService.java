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

    public RegistroGasto update(String id, RegistroGasto novoGasto) {
        Optional<RegistroGasto> gastoExistente = repository.findById(id);
        if (gastoExistente.isEmpty()) {
            throw new RuntimeException("RegistroGasto not found with id: " + id);
        }

        RegistroGasto gasto = gastoExistente.get();

        // update allowed fields
        gasto.setUserId(novoGasto.getUserId());
        gasto.setMes(novoGasto.getMes());
        gasto.setAno(novoGasto.getAno());
        gasto.setReportUrl(novoGasto.getReportUrl());

        return repository.save(gasto);
    }
}
