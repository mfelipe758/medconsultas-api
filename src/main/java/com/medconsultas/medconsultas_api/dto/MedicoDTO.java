package com.medconsultas.medconsultas_api.dto;

import com.medconsultas.medconsultas_api.entity.Especialidade;
import com.medconsultas.medconsultas_api.entity.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {
    private Long id;
    private String nome;
    private Integer crm;
    private LocalDate dataInscricao;
    private Set<Especialidade> especialidades;

    public MedicoDTO(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.dataInscricao = medico.getDataInscricao();
        this.especialidades = medico.getEspecialidades();
    }
}
