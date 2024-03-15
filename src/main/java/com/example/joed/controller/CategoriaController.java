package com.example.joed.controller;
import com.example.joed.model.Categoria;
import com.example.joed.repository.CategoriaRepository;

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



@RestController
@RequestMapping("categoria")
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    CategoriaRepository repository;

     @GetMapping
     public List<Categoria> listarCategorias(){
         return repository.findAll();
     }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria criarCategoria(@RequestBody Categoria categoria){ 
      log.info("Criando uma categoria" + categoria);
      repository.save(categoria);
      return categoria;
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> listarCategoria(@PathVariable Long id){
        log.info("buscar categoria por id {} ", id);
        return repository
                        .findById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}") 
    public ResponseEntity<Object> apagarCategoria(@PathVariable Long id){
        log.info("Apagando categoria com id {} ", id);
        getCategoriaId(id);

        repository.deleteById(id);
        return ResponseEntity.noContent().build(); 
    }

    @PutMapping("{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        log.info("atualizando categoria com id {} para {}", id, categoria);
         
       getCategoriaId(id);
       categoria.setId(id);
       repository.save(categoria);
       return ResponseEntity.ok(categoria);
    }

    private void getCategoriaId(Long id) {
      repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,  "Categoria não encontrado"));
    }

}