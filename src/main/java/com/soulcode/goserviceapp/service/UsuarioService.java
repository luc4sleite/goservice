package com.soulcode.goserviceapp.service;

import com.soulcode.goserviceapp.domain.*;
import com.soulcode.goserviceapp.repository.UsuarioRepository;
import com.soulcode.goserviceapp.service.exceptions.UsuarioNaoAutenticadoException;
import com.soulcode.goserviceapp.service.exceptions.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    // IoC -> Inversão de Controle
    // DI -> Injeção de Dependência

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Long paginasRegistros(){
        Long totalRecords = usuarioRepository.count();
        Long totalPages = totalRecords / 10;
        if (totalRecords % 10 != 0){
            totalPages++;
        }
        return totalPages;
    }

    public List<Usuario> findLimited(int offset){
        return usuarioRepository.findLimited(offset);
    }

//    @Cacheable(cacheNames = "redisCache2")
    public List<Usuario> findAll(){
        System.err.println("BUSCANDO USUARIOS NO BANCO DE DADOS...");
        return usuarioRepository.findAll();
    }
  
    public Usuario findByEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new UsuarioNaoEncontradoException();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> result = usuarioRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UsuarioNaoEncontradoException();
    }

    public List<Usuario> findByName(String nome){
        List<Usuario> usuario = usuarioRepository.findByName(nome);
        if(!usuario.isEmpty()){
            return usuario;
        } else {
            throw  new UsuarioNaoEncontradoException();
        }
    }

    public Usuario createUser(Usuario usuario) {
        String passwordEncoded = encoder.encode(usuario.getSenha());
        usuario.setSenha(passwordEncoded);

        switch (usuario.getPerfil()) {
            case PRESTADOR:
                return createAndSavePrestador(usuario);
            case ADMIN:
                return createAndSaveAdministrador(usuario);
            case CLIENTE:
            default:
                return createAndSaveCliente(usuario);
        }
    }

    private Administrador createAndSaveAdministrador(Usuario u) {
        Administrador admin = new Administrador(u.getId(), u.getNome(), u.getEmail(), u.getSenha(), u.getPerfil(), u.getHabilitado(), u.getEndereco());
        return usuarioRepository.save(admin);
    }

    private Prestador createAndSavePrestador(Usuario u) {
        Prestador prestador = new Prestador(u.getId(), u.getNome(), u.getEmail(), u.getSenha(), u.getPerfil(), u.getHabilitado(), u.getEndereco());
        return usuarioRepository.save(prestador);
    }

    private Cliente createAndSaveCliente(Usuario u) {
        Cliente cliente = new Cliente(u.getId(), u.getNome(), u.getEmail(), u.getSenha(), u.getPerfil(), u.getHabilitado(), u.getEndereco());
        return usuarioRepository.save(cliente);
    }

    @Transactional
    public void disableUser(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.updateEnableById(false, id);
            return;
        }
        throw new UsuarioNaoEncontradoException();
    }

    @Transactional
    public void enableUser(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.updateEnableById(true, id);
            return;
        }
        throw new UsuarioNaoEncontradoException();
    }
    public List<Usuario> findbyPerfil() {
        return usuarioRepository.findbyPerfil();
    }

    public Usuario findAuthenticated(Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()){
            Optional<Usuario> usuario = usuarioRepository.findByEmail(authentication.getName());
            if (usuario.isPresent()){
                return usuario.get();
            } else {
                throw new UsuarioNaoEncontradoException();
            }
        } throw new UsuarioNaoAutenticadoException();
    }
}