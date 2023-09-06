package com.soulcode.goserviceapp.repository;

import com.soulcode.goserviceapp.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = "SELECT * FROM enderecos WHERE id = ?", nativeQuery = true)
    Endereco findEnderecoById(Long id);

    @Modifying
    @Query(value = "UPDATE enderecos e SET e.uf = ?1, e.cidade = ?2, e.logradouro = ?3, e.numero = ?4 WHERE e.id = ?5", nativeQuery = true)
    void updateEnderecoById(String uf, String cidade, String logradouro, String numero, Long id);
}
