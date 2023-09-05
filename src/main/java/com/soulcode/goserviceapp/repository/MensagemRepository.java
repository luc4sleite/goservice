package com.soulcode.goserviceapp.repository;

import com.soulcode.goserviceapp.domain.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    @Query(value = "SELECT * FROM mensagens WHERE agendamento_id = ?", nativeQuery = true)
    List<Mensagem> findByAgendamentoId(Long id);

    @Query(value = "SELECT * FROM mensagens WHERE remetente_id = ?", nativeQuery = true)
    List<Mensagem> findByRemetenteId(Long id);
}
