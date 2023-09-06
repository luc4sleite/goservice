package com.soulcode.goserviceapp.service;

import com.soulcode.goserviceapp.domain.*;
import com.soulcode.goserviceapp.repository.EnderecoRepository;
import com.soulcode.goserviceapp.service.exceptions.EnderecoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco findEnderecoById(Long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if(endereco.isPresent()){
            return endereco.get();
        }else{
            throw new RuntimeException("Endereço não encontrado");
        }
    }

    public Cliente userToCliente(Usuario usuario){
        return (Cliente) usuario;
    }

    public Prestador userToPrestador(Usuario usuario){
        return (Prestador) usuario;
    }

    public Endereco updateUserCliente(Usuario usuario){
        Cliente cliente = userToCliente(usuario);
        return updateUsuer(cliente);
    }

    public Endereco updateUserPrestador(Usuario usuario){
        Prestador prestador = userToPrestador(usuario);
        return updateUsuer(prestador);
    }

    public Endereco updateUsuer(Usuario usuario){
        if(usuario.getEndereco().getId() == null){
            return enderecoRepository.save(usuario.getEndereco());
        }else{
            Optional<Endereco> endereco = enderecoRepository.findById(usuario.getEndereco().getId());
            if (endereco.isPresent()){
                return endereco.get();
            }
            throw new RuntimeException("Endereço não encontrado");
        }

    }

    @Transactional
    public void updateEndereco(String uf, String cidade, String logradouro, String numero, Long id, Endereco endereco){
        if(endereco != null) {
            enderecoRepository.updateEnderecoById(uf, cidade, logradouro, numero, id);
        }else{
            throw new RuntimeException("Endereço não encontrado");
        }
    }
}
