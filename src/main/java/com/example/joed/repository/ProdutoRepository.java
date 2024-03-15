package com.example.joed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.joed.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
