package com.soulcode.goserviceapp.domain;

import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String uf;

    @Column(nullable = true, length = 150)
    private String cidade;

    @Column(length = 150)
    private String logradouro;

    @Column
    private String numero;

    public Endereco() {
    }

    public Endereco(String uf, String cidade, String logradouro, String numero) {
        this.uf = uf;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
    }

}