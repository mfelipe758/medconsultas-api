package com.medconsultas.medconsultas_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {
    private String crm;
    private String nome;
    private String especialidade;
    private String email;
}
