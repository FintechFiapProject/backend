package com.example.fintech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "registro_gasto")
@Getter @Setter
public class RegistroGasto {

    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;
    private int mes;
    private int ano;

    @Column(name = "report_url")
    private String reportUrl;
}
