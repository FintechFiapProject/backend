package com.example.fintech.repository;

import com.example.fintech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroGastoRepository extends JpaRepository<User, String> {
}
