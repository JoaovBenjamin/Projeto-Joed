package com.example.joed.controller;
import com.example.joed.model.Categoria;

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



@RestController
@RequestMapping("categoria")
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Categoria> repository = new ArrayList<>();

    @GetMapping
    public List<Categoria> listarCategorias(){
        return repository;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria criarCategoria(@RequestBody Categoria categoria){ 
        log.info("cadastrando categoria " + categoria);
        repository.add(categoria);
        return categoria;
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> listarCategoria(@PathVariable Long id){
        log.info("buscar categoria por id {} ", id);
        var categoriaEncontrada = getCategoriaId(id);

        if (categoriaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(categoriaEncontrada.get());
    }

    @DeleteMapping("{id}") 
    public ResponseEntity<Object> apagarCategoria(@PathVariable Long id){
        log.info("Apagando categoria com id {} ", id);

        var categoriaEncontrada = getCategoriaId(id);

        if (categoriaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        repository.remove(categoriaEncontrada.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        log.info("atualizando categoria com id {} para {}", id, categoria);
         
        var categoriaEncontrada = getCategoriaId(id);

        if (categoriaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        var categoriaAntiga = categoriaEncontrada.get();
        var categoriaNova = new Categoria(id, 
                                          categoria.nome(), 
                                          categoria.icone());

        repository.remove(categoriaAntiga);
        repository.add(categoriaNova);

        return ResponseEntity.ok(categoriaNova);

    }

    private Optional<Categoria> getCategoriaId(Long id) {
        var categoriaEncontrada = repository
                                    .stream()
                                    .filter( c -> c.id().equals(id))
                                    .findFirst();
        return categoriaEncontrada;
    }

}