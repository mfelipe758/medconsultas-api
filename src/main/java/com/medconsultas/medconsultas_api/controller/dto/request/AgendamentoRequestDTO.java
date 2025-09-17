package com.medconsultas.medconsultas_api.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgendamentoRequestDTO {
    private Long especialidadeId;
    private Long medicoId;
    private Long pacienteId;
    private Long horarioId;
    private LocalDate dataConsulta;
}
