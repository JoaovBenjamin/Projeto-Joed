package com.example.joed.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.joed.model.Produto;
import com.example.joed.repository.ProdutoRepository;

@RestController
@RequestMapping("produto")

public class ProdutoController {
    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    ProdutoRepository repository;
    
    @GetMapping
    public List<Produto> getProduto(){
        return repository.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<Produto> listarProduto(@PathVariable Long id){
        log.info("buscar produto por id {} ", id);
        return repository
                        .findById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto criarProduto(@RequestBody Produto produto){
        log.info("Cadastrando novo produto" + produto);
        repository.save(produto);
        return produto;
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto>  atualizarProduto (@PathVariable long id, @RequestBody Produto produto){
        log.info("Atuliazando produto com id {} para {}",id,produto);
     
        getProdutoId(id);
        produto.setId(id);
        repository.save(produto);
        return ResponseEntity.ok(produto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable long id){
            log.info("Excluindo produto do id {}",id);

            getProdutoId(id);
            repository.deleteById(id);
            
            return ResponseEntity.noContent().build();
    }
    
    private void getProdutoId(Long id){
       repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado o produto"));

    }
}