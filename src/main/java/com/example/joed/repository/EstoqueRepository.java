package com.example.joed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.joed.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
