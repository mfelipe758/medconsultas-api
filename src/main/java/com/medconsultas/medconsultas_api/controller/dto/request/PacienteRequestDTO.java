package com.medconsultas.medconsultas_api.controller.dto.request;

import com.medconsultas.medconsultas_api.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteRequestDTO {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private Long usuarioId;
}
