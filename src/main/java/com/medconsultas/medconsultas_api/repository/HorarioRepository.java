package com.medconsultas.medconsultas_api.repository;

import com.medconsultas.medconsultas_api.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
}
