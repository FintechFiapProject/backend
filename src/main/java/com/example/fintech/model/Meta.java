package com.example.fintech.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "meta")
@Getter
@Setter
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;
    private String title;
    private String description;
    private double progress;
}
