package com.example.joed.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Estoque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "{estoque.notblank}")
    @Size(message = "{estoque.size}", min = 0, max = 20000)
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    @NotBlank(message = "{estoque.produto.notblank}")
    private Produto produto;
}