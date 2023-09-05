package com.soulcode.goserviceapp.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public Mensagem() {
    }

    public Mensagem(Long id, String conteudo, LocalDateTime dataHora, Usuario remetente, Usuario destinatario, Agendamento agendamento) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataHora = dataHora;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.agendamento = agendamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
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
