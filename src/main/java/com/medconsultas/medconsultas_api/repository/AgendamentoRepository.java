package com.medconsultas.medconsultas_api.repository;

import com.medconsultas.medconsultas_api.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
