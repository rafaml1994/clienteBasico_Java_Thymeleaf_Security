package com.example.hi_t2_servidor.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    private String nif;
}

