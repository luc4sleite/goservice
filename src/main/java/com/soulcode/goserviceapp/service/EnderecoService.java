package com.soulcode.goserviceapp.service;

import com.soulcode.goserviceapp.domain.Endereco;
import com.soulcode.goserviceapp.domain.Servico;
import com.soulcode.goserviceapp.repository.EnderecoRepository;
import com.soulcode.goserviceapp.service.exceptions.EnderecoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco findById(Long id) {
        Optional<Endereco> result = enderecoRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new EnderecoNaoEncontradoException();
    }

    public List<Endereco> findByEnderecoEmail(String email) {
        return enderecoRepository.findByEnderecoEmail(email);
    }

    public Endereco update(Endereco endereco) {
        Endereco updatedEndereco = this.findById(endereco.getId());
        updatedEndereco.setCidade(endereco.getCidade());
        updatedEndereco.setLogradouro(endereco.getLogradouro());
        updatedEndereco.setNumero(endereco.getNumero());
        updatedEndereco.setUf(endereco.getUf());
        return enderecoRepository.save(updatedEndereco);
    }

}
