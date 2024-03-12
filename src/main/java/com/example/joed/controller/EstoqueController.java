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

import com.example.joed.model.Estoque;
@RestController
@RequestMapping("estoque")
public class EstoqueController {
       Logger log = LoggerFactory.getLogger(getClass());
       List<Estoque> repository = new ArrayList<>();
    
    @GetMapping
    public List<Estoque> getProduto(){
        return repository;
    }
    @GetMapping("{id}")
    public ResponseEntity<Estoque> listarEstoque(@PathVariable Long id){
        log.info("buscar estoque do  produto por id {} ", id);
        var estoqueProdutoEncontrada = getEstoqueId(id);

        if (estoqueProdutoEncontrada.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(estoqueProdutoEncontrada.get());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Estoque criarEstoque(@RequestBody Estoque estoque){
        log.info("Cadastrando novo estoque de produto" + estoque);
        repository.add(estoque);
        return estoque;
    }

    @PutMapping("{id}")
    public ResponseEntity<Estoque>  atualizarEstoque (@PathVariable long id, @RequestBody Estoque estoque){
        log.info("Atuliazando estoqeu do produto com id {} para {}",id,estoque);
        var estoqueProdutoEncontrada = getEstoqueId(id);

        if (estoqueProdutoEncontrada.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var estoqueAntigo = estoqueProdutoEncontrada.get();
        var estoqueNovo =  new Estoque(id,
                                        estoque.quantidade(),
                                        estoque.produto());
        
        repository.remove(estoqueAntigo);
        repository.add(estoqueNovo);

        return ResponseEntity.ok(estoqueNovo);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletarEstoque(@PathVariable long id){
            log.info("Excluindo estoque do produto do id {}",id);

            var estoqueEncontrado = getEstoqueId(id);

            if(estoqueEncontrado.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            repository.remove(estoqueEncontrado.get());
            return ResponseEntity.noContent().build();
    }
    
    private Optional<Estoque> getEstoqueId(Long id){
        var idEstoqueProdutoEncontrado = repository.stream()
                                  .filter(p -> p.id().equals(id))
                                  .findFirst();
        return idEstoqueProdutoEncontrado;

}
}