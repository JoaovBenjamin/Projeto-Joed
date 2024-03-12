package com.example.joed.model;

import java.util.Random;

public record Produto(Long id, String nome, String icone,Categoria categoria, String descricao) {
    public Produto(Long id, String nome, String icone, Categoria categoria, String descricao){
        this.id = Math.abs(new Random().nextLong());
        this.nome = nome;
        this.icone = icone;
        this.categoria = categoria;
        this.descricao = descricao;
    }
}