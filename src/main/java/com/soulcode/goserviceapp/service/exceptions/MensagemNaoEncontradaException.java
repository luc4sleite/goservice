package com.soulcode.goserviceapp.service.exceptions;

public class MensagemNaoEncontradaException extends RuntimeException{
    public MensagemNaoEncontradaException() {
        super("Mensagem não foi encontrada");
    }

    public MensagemNaoEncontradaException(String message) {
        super(message);
    }
}
