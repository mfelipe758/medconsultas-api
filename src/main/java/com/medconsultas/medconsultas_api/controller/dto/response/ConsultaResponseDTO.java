package com.medconsultas.medconsultas_api.controller.dto.response;

import java.time.LocalDateTime;

public record ConsultaResponseDTO(
        Long id,
        AgendamentoResponseDTO agendamento,
        LocalDateTime dataHoraRealizada,
        String diagnostico,
        String observacoes,
        String receita
) {}
