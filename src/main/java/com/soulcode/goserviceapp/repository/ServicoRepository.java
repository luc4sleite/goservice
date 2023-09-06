package com.soulcode.goserviceapp.repository;

import com.soulcode.goserviceapp.domain.Servico;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    @Query(value =
            "SELECT s.*" +
            " FROM servicos s" +
            " JOIN prestadores_servicos ps ON s.id = ps.servico_id" +
            " JOIN usuarios u ON u.id = ps.prestador_id" +
            " WHERE u.email = ?", nativeQuery = true)
    List<Servico> findByPrestadorEmail(String email);

    @Query(value = "SELECT * FROM servicos ORDER BY id LIMIT 10 OFFSET ((@pageNumber - 1) * 10)", nativeQuery = true)
    List<Servico> findLimited();

    @Query(value = "SELECT * FROM servicos WHERE UPPER(nome) LIKE UPPER(CONCAT('%', :servico, '%'))", nativeQuery = true)
    List<Servico> findByName(@Param("servico") String servico);
}
