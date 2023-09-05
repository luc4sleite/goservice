package com.soulcode.goserviceapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String uf;

    @Column(nullable = false, length = 150)
    private String cidade;

    @Column(nullable = false, length = 150)
    private String logradouro;

    @Column(nullable = false)
    private String numero;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    public Endereco(Long id, String uf, String cidade, String logradouro, String numero, Usuario usuario) {
        this.id = id;
        this.uf = uf;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(uf, endereco.uf) && Objects.equals(cidade, endereco.cidade) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(numero, endereco.numero) && Objects.equals(usuario, endereco.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uf, cidade, logradouro, numero, usuario);
    }
}
