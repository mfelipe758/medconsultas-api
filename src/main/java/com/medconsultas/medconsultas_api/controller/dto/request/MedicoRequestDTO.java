package com.medconsultas.medconsultas_api.controller.dto.request;

import com.medconsultas.medconsultas_api.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicoRequestDTO {
    private String nome;
    private Integer crm;
    private LocalDate dataInscricao;
    private Endereco endereco;
    private Long usuarioId;
    private Set<Long> especialidadesIds;
}
