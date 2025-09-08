package com.medconsultas.medconsultas_api.dto;

import com.medconsultas.medconsultas_api.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoDTO {
    private Long id;
    private Especialidade especialidade;
    private Medico medico;
    private Paciente paciente;
    private Consulta consulta;
    private Horario horario;
    private LocalDate dataConsulta;

    public AgendamentoDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.especialidade = agendamento.getEspecialidade();
        this.medico = agendamento.getMedico();
        this.paciente = agendamento.getPaciente();
        this.consulta = agendamento.getConsulta();
        this.horario = agendamento.getHorario();
        this.dataConsulta = agendamento.getDataConsulta();
    }
}
