package com.medconsultas.medconsultas_api.dto;

import lombok.Data;

@Data
public class MedicoDTO {
    private String crm;
    private String nome;
    private String especialidade;
    private String email;
}
