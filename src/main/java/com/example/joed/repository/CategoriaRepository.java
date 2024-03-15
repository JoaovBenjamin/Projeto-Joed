package com.example.joed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.joed.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    
} 
