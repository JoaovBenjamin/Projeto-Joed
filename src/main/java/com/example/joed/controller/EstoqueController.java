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

import com.example.joed.model.Estoque;
import com.example.joed.repository.EstoqueRepository;
@RestController
@RequestMapping("estoque")
public class EstoqueController {
       Logger log = LoggerFactory.getLogger(getClass());
       
       @Autowired
       EstoqueRepository  repository;
    
        @GetMapping
        public List<Estoque> getEstoque(){
            return repository.findAll();
        }
    @GetMapping("{id}")
    public ResponseEntity<Estoque> listarEstoque(@PathVariable Long id){
        log.info("buscar estoque do  produto por id {} ", id);
        return repository
                        .findById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Estoque criarEstoque(@RequestBody Estoque estoque){
        log.info("Cadastrando novo estoque de produto" + estoque);
        repository.save(estoque);
        return estoque;
    }

    @PutMapping("{id}")
    public ResponseEntity<Estoque>  atualizarEstoque (@PathVariable long id, @RequestBody Estoque estoque){
        log.info("Atuliazando estoqeu do produto com id {} para {}",id,estoque);
        getEstoqueId(id);
        estoque.setId(id);
        repository.save(estoque);
        return ResponseEntity.ok(estoque);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletarEstoque(@PathVariable long id){
            log.info("Excluindo estoque do produto do id {}",id);

            getEstoqueId(id);
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
    
    private void getEstoqueId(Long id){
        repository
                .findById(id)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Estoque não encontrado"));

}
}