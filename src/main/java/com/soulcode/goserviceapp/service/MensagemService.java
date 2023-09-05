package com.soulcode.goserviceapp.service;

import com.soulcode.goserviceapp.domain.Cliente;
import com.soulcode.goserviceapp.domain.Mensagem;
import com.soulcode.goserviceapp.repository.MensagemRepository;
import com.soulcode.goserviceapp.service.exceptions.MensagemNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MensagemService {
    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PrestadorService prestadorService;

    @Autowired
    private ServicoService servicoService;

    public Mensagem findById(Long id){
        Optional<Mensagem> mensagem = mensagemRepository.findById(id);
        if(mensagem.isPresent()) {
            return mensagem.get();
        }
        throw new MensagemNaoEncontradaException();
    }

    public Mensagem createMensagemByCliente(Authentication authentication, Long agendamentoId, LocalDateTime dataHora, String conteudo){
        Mensagem mensagem = new Mensagem();
        mensagem.setConteudo(conteudo);
        mensagem.setDataHora(dataHora);
        mensagem.setRemetente(clienteService.findAuthenticated(authentication));
        mensagem.setAgendamento(agendamentoService.findById(agendamentoId));
        mensagem.setDestinatario(agendamentoService.findById(agendamentoId).getPrestador());
        return mensagemRepository.save(mensagem);
    }

    public Mensagem createMensagemByPrestador(Authentication authentication, Long agendamentoId, LocalDateTime dataHora, String conteudo){
        Mensagem mensagem = new Mensagem();
        mensagem.setConteudo(conteudo);
        mensagem.setDataHora(dataHora);
        mensagem.setRemetente(prestadorService.findAuthenticated(authentication));
        mensagem.setAgendamento(agendamentoService.findById(agendamentoId));
        mensagem.setDestinatario(agendamentoService.findById(agendamentoId).getCliente());
        return mensagemRepository.save(mensagem);
    }

    public Mensagem update(Authentication authentication, Long id, String conteudo){
        Mensagem mensagem = findById(id);
        if(mensagem.getRemetente().getId().equals(clienteService.findAuthenticated(authentication).getId())){
            mensagem.setConteudo(conteudo);
            return mensagemRepository.save(mensagem);
        }
        throw new MensagemNaoEncontradaException();
    }

    public List<Mensagem> findByCliente(Authentication authentication){
        Cliente cliente = clienteService.findAuthenticated(authentication);
        return mensagemRepository.findByRemetenteId(cliente.getId());
    }

    public List<Mensagem> findByAgendamentoId(Long id){
        return mensagemRepository.findByAgendamentoId(id);
    }
}
