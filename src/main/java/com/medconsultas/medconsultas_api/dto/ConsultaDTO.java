package com.medconsultas.medconsultas_api.dto;

import com.medconsultas.medconsultas_api.entity.Consulta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.medconsultas.medconsultas_api.entity.Medico;
import com.medconsultas.medconsultas_api.entity.Paciente;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultaDTO {

    private Long id;
    private LocalDateTime dataHora;


    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.dataHora = consulta.getDataHora();
    }
}
