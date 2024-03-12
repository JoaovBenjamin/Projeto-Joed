package com.example.joed.model;


import java.util.Random;

public record Estoque(Long id, int quantidade, Produto produto) {
    public Estoque(Long id, int quantidade, Produto produto){
        this.id = Math.abs(new Random().nextLong());
        this.produto = produto;
        this.quantidade = quantidade;
    }
}