package com.soulcode.goserviceapp.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "mensagens")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 250)
    private String conteudo;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario remetente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario destinatario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Agendamento agendamento;

    public Mensagem(Long id, String conteudo, LocalDateTime dataHora, Usuario remetente, Usuario destinatario, Agendamento agendamento) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataHora = dataHora;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.agendamento = agendamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensagem mensagem = (Mensagem) o;
        return Objects.equals(id, mensagem.id) &&
                Objects.equals(conteudo, mensagem.conteudo) &&
                Objects.equals(dataHora, mensagem.dataHora) &&
                Objects.equals(remetente, mensagem.remetente) &&
                Objects.equals(destinatario, mensagem.destinatario) &&
                Objects.equals(agendamento, mensagem.agendamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conteudo, dataHora, remetente, destinatario, agendamento);
    }
}
