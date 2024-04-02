package com.example.joed.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "{produto.nome.notblank}")
    @Size(message = "{produto.nome.size}", min = 5, max = 50)
    private String nome;
    @Pattern(message = "{produto.pattern}",regexp = ".*\\.(png|jpg|jpeg|svg)")
    private String icone;
    @Size(message = "{produto.size}",min = 0, max = 255)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @NotBlank(message = "{produto.categoria.notblank}")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "estoque_id")
    @NotBlank(message = "{produto.estoque.notblank}")
    private Estoque estoque;
}