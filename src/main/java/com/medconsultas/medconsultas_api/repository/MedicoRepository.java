package com.medconsultas.medconsultas_api.repository;

import com.medconsultas.medconsultas_api.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, String> {
}
