package com.example.fintech.service;

import com.example.fintech.model.User;
import com.example.fintech.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public List<User> list() {
        return repository.findAll();
    }

    public Optional<User> find(String id) {
        return repository.findById(id);
    }

    public User save(User usuario) {
        return repository.save(usuario);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
