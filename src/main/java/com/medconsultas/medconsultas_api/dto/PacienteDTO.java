package com.medconsultas.medconsultas_api.dto;

import com.medconsultas.medconsultas_api.entity.Consulta;
import com.medconsultas.medconsultas_api.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private List<Consulta> consultas;

    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.dataNascimento = paciente.getDataNascimento();
        this.consultas = paciente.getConsultas();
    }
}
