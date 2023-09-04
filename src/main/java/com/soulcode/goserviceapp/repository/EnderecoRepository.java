package com.soulcode.goserviceapp.repository;

import com.soulcode.goserviceapp.domain.Endereco;
import com.soulcode.goserviceapp.domain.Usuario;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

    Optional<Endereco> findByEmail(String email);


    @Modifying
    @Query(value =
            "UPDATE enderecos e " +
                    "SET e.cidade = ?, e.logradouro = ?, e.numero = ?, e.uf = ? " +
                    "WHERE usuarios.email = ?", nativeQuery = true)
    void updateenderecoByEmail(String cidade, String logradouro, String numero, String uf, String email);


}
