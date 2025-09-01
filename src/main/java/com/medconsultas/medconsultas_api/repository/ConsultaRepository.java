package com.medconsultas.medconsultas_api.repository;

import com.medconsultas.medconsultas_api.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByPacienteCpf(String pacienteCpf);
    List<Consulta> findByMedicoCrm(String medicoCrm);
}
