package com.soulcode.goserviceapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="servicos") @Setter @Getter @NoArgsConstructor
public class Servico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome do serviço não pode ser vazio.")
    @Column(nullable = false, length = 100)
    private String nome;
    @NotBlank(message = "A descrição do serviço não pode ser vazia.")
    @Column(nullable = false)
    private String descricao;
    @NotBlank(message = "A categoria do serviço não pode ser vazia.")
    @Column(nullable = false)
    private String categoria;


    public Servico(Long id, String nome, String descricao, String categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return Objects.equals(id, servico.id) &&
                Objects.equals(nome, servico.nome) &&
                Objects.equals(descricao, servico.descricao) &&
                Objects.equals(categoria, servico.categoria);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, categoria);
    }
}
