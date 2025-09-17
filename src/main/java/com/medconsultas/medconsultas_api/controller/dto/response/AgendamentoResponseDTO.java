package com.medconsultas.medconsultas_api.controller.dto.response;

import com.medconsultas.medconsultas_api.entity.StatusAgendamento;

import java.time.LocalDate;

public record AgendamentoResponseDTO(
        Long id,
        EspecialidadeResponseDTO especialidade,
        MedicoResponseDTO medico,
        PacienteResponseDTO paciente,
        HorarioResponseDTO horario,
        LocalDate dataConsulta,
        StatusAgendamento status
) {}
