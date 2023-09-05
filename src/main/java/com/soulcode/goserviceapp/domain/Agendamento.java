package com.soulcode.goserviceapp.domain;

import com.soulcode.goserviceapp.domain.enums.StatusAgendamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "agendamentos")
@Getter @Setter
public class Agendamento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O campo do agendamento referente ao cliente não pode ser vazio.")
    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;
    @NotNull(message = "O campo do agendamento referente ao prestador não pode ser vazio.")
    @ManyToOne
    @JoinColumn(nullable = false)
    private Prestador prestador;
    @NotNull(message = "O campo do agendamento referente ao serviço não pode ser vazio.")
    @ManyToOne
    @JoinColumn(nullable = false)
    private Servico servico;
    @NotNull(message = "O status do agendamento não pode ser vazio.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento statusAgendamento;
    @NotNull(message = "A data do agendamento não pode ser vazia.")
    @Column(nullable = false)
    private  LocalDate data;
    @NotNull(message = "A hora do agendamento não pode ser vazia.")
    @Column(nullable = false)
    private LocalTime hora;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataHoraRegistro;

    public Agendamento(){
        this.statusAgendamento = StatusAgendamento.AGUARDANDO_CONFIRMACAO;
    }

    public Agendamento(Long id, Cliente cliente, Prestador prestador, Servico servico, StatusAgendamento statusAgendamento, LocalDate data, LocalTime hora, LocalDateTime dataHoraRegistro) {
        this.id = id;
        this.cliente = cliente;
        this.prestador = prestador;
        this.servico = servico;
        this.statusAgendamento = statusAgendamento;
        this.data = data;
        this.hora = hora;
    }

    public boolean isCancelable(){
        return statusAgendamento.equals(StatusAgendamento.AGUARDANDO_CONFIRMACAO);
    }

    public boolean isConfirmable(){
        return statusAgendamento.equals(StatusAgendamento.AGUARDANDO_CONFIRMACAO);
    }

    public boolean isRealizable(){
        return statusAgendamento.equals(StatusAgendamento.CONFIRMADO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento agendamento = (Agendamento) o;
        return Objects.equals(id, agendamento.id) &&
                Objects.equals(cliente, agendamento.cliente) &&
                Objects.equals(prestador, agendamento.prestador) &&
                Objects.equals(servico, agendamento.servico) &&
                statusAgendamento == agendamento.statusAgendamento &&
                Objects.equals(data, agendamento.data) &&
                Objects.equals(hora, agendamento.hora) &&
                Objects.equals(dataHoraRegistro, agendamento.dataHoraRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, prestador, servico, statusAgendamento, data, hora, dataHoraRegistro);
    }
}
