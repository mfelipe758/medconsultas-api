package com.medconsultas.medconsultas_api.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaRequestDTO {
    private Long agendamentoId;
    private LocalDateTime dataHoraRealizada;
    private String diagnostico;
    private String observacoes;
    private String receita;
}
