package com.soulcode.goserviceapp.service.exceptions;

public class DataAgendamentoInvalidaException extends RuntimeException{

    public DataAgendamentoInvalidaException() {
        super("Você não pode agendar um serviço em uma data anterior a hoje.");
    }

    public DataAgendamentoInvalidaException(String message) {
        super(message);
    }
}
