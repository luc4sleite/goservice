package com.soulcode.goserviceapp.repository;

import com.soulcode.goserviceapp.domain.Endereco;
import com.soulcode.goserviceapp.domain.Usuario;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Modifying
    @Query(value = "UPDATE usuarios u SET u.senha = ? WHERE u.email = ?", nativeQuery = true)
    void updatePasswordByEmail(String senha, String email);

    @Modifying
    @Query(value = "UPDATE usuarios u SET u.habilitado = ? WHERE u.id = ?", nativeQuery = true)
    void updateEnableById(boolean habilitado, Long id);

    @Query(value = "SELECT u.perfil AS perfil, COUNT(*) AS quantidade FROM usuarios AS u GROUP BY u.perfil", nativeQuery = true)
    List<Usuario> findbyPerfil();

    @Query(value = "SELECT * FROM usuarios ORDER BY id LIMIT 10 OFFSET ((@pageNumber - 1) * 10)", nativeQuery = true)
    List<Usuario> findLimited();

    @Query(value = "SELECT * FROM usuarios WHERE UPPER(nome) LIKE UPPER(CONCAT('%', :nome, '%'))", nativeQuery = true)
    List<Usuario> findByName(@Param("nome") String nome);

//    @Query (value = "SELECT * FROM endereco JOIN usuario ON ")
//    List<Endereco> findbyEndereco();
}
