package com.example.joed.config;
import java.math.BigDecimal;
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
                Categoria.builder().id(1L).nome("Cama, Mesa e Banho").icone("bed.png").build(),
                Categoria.builder().id(2L).nome("Banheiro").icone("shower.png").build(),
                Categoria.builder().id(3L).nome("Cozinha").icone("cutlery.png").build()
            )
        );

      
        estoqueRepository.saveAll(
            List.of(
                Estoque.builder()
                                .id(1L)
                                .quantidade(new BigDecimal(18))
                                .build(),
                Estoque.builder()
                                .id(2L)
                                .quantidade(new BigDecimal(50))
                                .build(),
                Estoque.builder()
                                .id(3L)
                                .quantidade(new BigDecimal(100))
                                .build()
                                
                                
                )
        );  
        
        produtoRepository.saveAll(
            List.of(
                Produto.builder()
                                .id(1L)
                                .nome("Fronha")
                                .descricao("Fronha para travesseiro")
                                .icone("fronha.png")
                                .categoria(categoriaRepository.findById(1L).get())
                                .estoque(estoqueRepository.findById(1L).get())
                                .build(),
            
                Produto.builder()
                                .id(2L)
                                .nome("Chuveiro")
                                .descricao("Chuveiro Lorrenzeti")
                                .icone("shower.png")
                                .categoria(categoriaRepository.findById(2L).get())
                                .estoque(estoqueRepository.findById(2L).get())
                                .build(),

                Produto.builder()
                                .id(3L)
                                .nome("Kit Talher")
                                .descricao("Kit de garfo, colher e faca")
                                .icone("cutlery.png")
                                .categoria(categoriaRepository.findById(3L).get())
                                .estoque(estoqueRepository.findById(3L).get())
                                .build()
            
        )
    );
 } 
    
}
