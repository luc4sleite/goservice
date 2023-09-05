package com.soulcode.goserviceapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;

@Document(collection = "agendamentos")
@Getter @Setter @NoArgsConstructor
public class AgendamentoLog {
    @Id
    private String id;

    private String cliente;

    private String prestador;

    private String servico;

    private String statusAgendamento;

    private String data;

    private String hora;
    @Field(targetType = FieldType.DATE_TIME)
    private LocalDateTime dataAgendamento = LocalDateTime.now();

    public AgendamentoLog(String id, String cliente, String prestador, String servico, String statusAgendamento, String data, String hora) {
        this.id = id;
        this.cliente = cliente;
        this.prestador = prestador;
        this.servico = servico;
        this.statusAgendamento = statusAgendamento;
        this.data = data;
        this.hora = hora;
    }

    public AgendamentoLog (Agendamento agendamento) {
        this.cliente = agendamento.getCliente().getNome();
        this.prestador = agendamento.getPrestador().getNome();
        this.servico = agendamento.getServico().getNome();
        this.statusAgendamento = agendamento.getStatusAgendamento().getDescricao();
        this.data = agendamento.getData().toString();
        this.hora = agendamento.getHora().toString();
    }

}
