package com.example.joed.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.joed.model.Categoria;
import com.example.joed.model.Estoque;
import com.example.joed.model.Produto;
import com.example.joed.repository.CategoriaRepository;
import com.example.joed.repository.EstoqueRepository;
import com.example.joed.repository.ProdutoRepository;


@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired 
    ProdutoRepository produtoRepository;


    @Override
    public void run(String... args) throws Exception {
        categoriaRepository.saveAll(
            List.of(
                Categoria.builder().id(1L).nome("Cama").icone("bed").build(),
                Categoria.builder().id(2L).nome("Banheiro").icone("shower").build(),
                Categoria.builder().id(3L).nome("Cozinha").icone("cutlery").build()
            )
        );

        produtoRepository.saveAll(
            List.of(
                Produto.builder()
                                .id(1L)
                                .nome("Fronha")
                                .descricao("Fronha para travesseiro")
                                .icone("fronha")
                                .categoria(categoriaRepository.findById(1L).get())
                                .estoque(estoqueRepository.findById(1L).get())
                                .build(),
            
                Produto.builder()
                                .id(2L)
                                .nome("Chuveiro")
                                .descricao("Chuveiro Lorrenzeti")
                                .icone("shower")
                                .categoria(categoriaRepository.findById(2L).get())
                                .estoque(estoqueRepository.findById(2L).get())
                                .build(),

                Produto.builder()
                                .id(3L)
                                .nome("Kit Talher")
                                .descricao("Kit de garfo, colher e faca")
                                .icone("cutlery")
                                .categoria(categoriaRepository.findById(3L).get())
                                .estoque(estoqueRepository.findById(3L).get())
                                .build()
            )
        );
        estoqueRepository.saveAll(
            List.of(
                Estoque.builder()
                                .id(1L)
                                .produto(produtoRepository.findById(1L).get())
                                .quantidade(150)
                                .build(),
                Estoque.builder()
                                .id(1L)
                                .produto(produtoRepository.findById(2L).get())
                                .quantidade(50)
                                .build(),
                Estoque.builder()
                                .id(1L)
                                .produto(produtoRepository.findById(3L).get())
                                .quantidade(23)
                                .build()
                                
                                
                )
        );   
    }
    
}
