package com.example.joed.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


import com.example.joed.model.Produto;

@RestController
@RequestMapping("produto")

public class ProdutoController {
    Logger log = LoggerFactory.getLogger(getClass());
    List<Produto> repository = new ArrayList<>();
    
    @GetMapping
    public List<Produto> getProduto(){
        return repository;
    }
    @GetMapping("{id}")
    public ResponseEntity<Produto> listarProduto(@PathVariable Long id){
        log.info("buscar produto por id {} ", id);
        var produtoEncontrada = getProdutoId(id);

        if (produtoEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(produtoEncontrada.get());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto criarProduto(@RequestBody Produto produto){
        log.info("Cadastrando novo produto" + produto);
        repository.add(produto);
        return produto;
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto>  atualizarProduto (@PathVariable long id, @RequestBody Produto produto){
        log.info("Atuliazando produto com id {} para {}",id,produto);
        var produtoEncontrado = getProdutoId(id);

        if (produtoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var produtoDesatualizado = produtoEncontrado.get();
        var produtoAtualizado = new Produto(id, 
                                            produto.nome(), 
                                            produto.icone(), 
                                            produto.categoria(), 
                                            produto.descricao());
        
        repository.remove(produtoDesatualizado);
        repository.add(produtoAtualizado);

        return ResponseEntity.ok(produtoAtualizado);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable long id){
            log.info("Excluindo produto do id {}",id);

            var produtoEncontrado = getProdutoId(id);

            if(produtoEncontrado.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            repository.remove(produtoEncontrado.get());
            return ResponseEntity.noContent().build();
    }
    
    private Optional<Produto> getProdutoId(Long id){
        var idProdutoEncontrado = repository.stream()
                                  .filter(p -> p.id().equals(id))
                                  .findFirst();
        return idProdutoEncontrado;

    }
}