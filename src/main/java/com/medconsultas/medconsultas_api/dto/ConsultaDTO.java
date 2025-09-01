package com.medconsultas.medconsultas_api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {
    private Long id;
    private String pacienteCpf;
    private String medicoCrm;
    private LocalDateTime dataHora;
    private String motivo;
}
