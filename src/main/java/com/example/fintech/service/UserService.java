package com.example.fintech.service;

import com.example.fintech.model.User;
import com.example.fintech.repository.UserRepository;
import com.example.fintech.utils.CryptoUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository repository;


    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public List<User> list() {
        return repository.findAll();
    }

    public Optional<User> find(Long id) {
        return repository.findById(id);
    }

    public User save(User usuario) {
        try {
            usuario.setPassword(CryptoUtils.encrypt(usuario.getPassword()));
        } catch (Exception e) {
            log.error("Error encrypting password: {}", e.getMessage());
            throw new RuntimeException("Failed to encrypt password", e);
        }
        try {
            return repository.save(usuario);
        } catch (Exception e) {
            log.error("Error saving user: {}", e.getMessage());
            throw new RuntimeException("Failed to save user", e);
        }

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User login(String email, String password) {
        try {
            User user = this.repository.findByEmail(email);

            if (user.getPassword().equals(CryptoUtils.encrypt(password))) {
                return user;
            }

            throw new RuntimeException("Invalid password");

        } catch(Exception e) {
            log.error("Error logging in user: {}", e.getMessage());
            throw new RuntimeException("Failed to login user", e);
        }
    }
}
