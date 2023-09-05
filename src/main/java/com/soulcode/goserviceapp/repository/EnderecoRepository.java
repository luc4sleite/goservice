package com.soulcode.goserviceapp.repository;

import com.soulcode.goserviceapp.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value =
            "SELECT s.*" +
                    " FROM enderecos e" +
                    " JOIN usuarios u ON e.usuario_id = u.id" +
                    " WHERE u.email = ?", nativeQuery = true)
            List<Endereco> findByEnderecoEmail(String email);
}
