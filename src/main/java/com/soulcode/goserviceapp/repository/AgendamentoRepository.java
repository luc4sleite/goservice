package com.soulcode.goserviceapp.repository;

import com.soulcode.goserviceapp.domain.Agendamento;
import com.soulcode.goserviceapp.domain.Servico;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query(value="SELECT a.* FROM agendamentos a JOIN usuarios u ON a.cliente_id = u.id WHERE u.email = ? ORDER BY data", nativeQuery = true)
    List<Agendamento> findByClienteEmail(String email);

    @Query(value = "SELECT a.* FROM agendamentos a JOIN usuarios u ON a.prestador_id = u.id WHERE u.email = ? ORDER BY data", nativeQuery = true)
    List<Agendamento> findByPrestadorEmail(String email);

    @Query(value =
            "SELECT status_agendamento, COUNT(status_agendamento)" +
                    "FROM agendamentos GROUP BY status_agendamento", nativeQuery = true)
    List<Servico> findServicoByStatus(Servico servico);

    @Query(value = "SELECT a.* FROM agendamentos a WHERE a.prestador_id = ?1 AND a.data = ?2 AND a.hora = ?3", nativeQuery = true)
    List<Agendamento> findByPrestadorIdAndDataHora(Long prestadorId, LocalDate data, LocalTime hora);


    @Query(value = "SELECT a.* FROM agendamentos a WHERE a.data BETWEEN ?1 AND ?2 AND a.prestador_id = ?3 ", nativeQuery = true)
    List<Agendamento> findByDateAgendamento(LocalDate dataInicial, LocalDate dataFinal, Long id);
}

