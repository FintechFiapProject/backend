package com.example.fintech.model;

import jakarta.persistence.Column;
import   jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String email;

    @Column(name = "image_url")
    private String imageUrl;
}
