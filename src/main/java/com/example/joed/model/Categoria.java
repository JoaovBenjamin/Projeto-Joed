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
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{categoria.nome.notblank}")
    @Size(message = "{categoria.nome.size}", min = 5, max = 50)
    private String nome;
    @Pattern(message = "{categoria.pattern}",regexp = ".*\\.(png|jpg|jpeg|svg)")
    private String icone;

}
