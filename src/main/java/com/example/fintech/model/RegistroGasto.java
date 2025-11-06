package com.example.fintech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "registro_gasto")
@Getter @Setter
public class RegistroGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private String userId;
    private int mes;
    private int ano;

    @Column(name = "report_url")
    private String reportUrl;
}
