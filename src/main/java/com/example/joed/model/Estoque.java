package com.example.joed.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Estoque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Produto produto;
    private int quantidade;
}