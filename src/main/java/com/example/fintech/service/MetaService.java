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

    public Optional<Meta> find(Long id) {
        return repository.findById(id);
    }

    public Meta save(Meta meta) {
        return repository.save(meta);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Meta update(Long id, Meta novaMeta) {
        Optional<Meta> metaExistente = repository.findById(id);
        if (metaExistente.isEmpty()) {
            throw new RuntimeException("Meta not found with id: " + id);
        }

        Meta meta = metaExistente.get();
        meta.setUserId(novaMeta.getUserId());
        meta.setDescription(novaMeta.getDescription());
        meta.setProgress(novaMeta.getProgress());
        meta.setTitle(novaMeta.getTitle());

        return repository.save(meta);
    }
}
