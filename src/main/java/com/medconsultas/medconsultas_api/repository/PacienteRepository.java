package com.medconsultas.medconsultas_api.repository;

import com.medconsultas.medconsultas_api.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
