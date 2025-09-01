package com.medconsultas.medconsultas_api.dto;

import lombok.Data;

@Data
public class PacienteDTO {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
}
