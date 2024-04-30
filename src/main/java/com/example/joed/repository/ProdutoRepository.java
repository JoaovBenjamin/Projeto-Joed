package com.example.joed.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.joed.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

        Page<Produto>  findByNome(String produto, Pageable pageable);

}
