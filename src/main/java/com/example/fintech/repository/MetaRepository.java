package com.example.fintech.repository;

import com.example.fintech.model.Meta;
import com.example.fintech.model.RegistroGasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaRepository extends JpaRepository<Meta, Long> {
}
