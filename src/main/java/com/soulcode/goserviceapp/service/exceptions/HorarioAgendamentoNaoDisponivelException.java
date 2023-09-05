package com.soulcode.goserviceapp.service.exceptions;

public class HorarioAgendamentoNaoDisponivelException extends RuntimeException{

    public HorarioAgendamentoNaoDisponivelException() {
        super("Horário de Agendamento não disponivel.");
    }

    public HorarioAgendamentoNaoDisponivelException(String message) {
        super(message);
    }
}
