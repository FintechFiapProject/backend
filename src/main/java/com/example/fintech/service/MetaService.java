package com.example.fintech.service;

import com.example.fintech.model.Meta;
import com.example.fintech.repository.MetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {
    private final MetaRepository repository;

    public MetaService(MetaRepository metaRepository) {
        this.repository = metaRepository;
    }

    public List<Meta> list() {
        return repository.findAll();
    }

    public Optional<Meta> find(String id) {
        return repository.findById(id);
    }

    public Meta save(Meta meta) {
        return repository.save(meta);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
