package com.medconsultas.medconsultas_api.dto;

import com.medconsultas.medconsultas_api.entity.Especialidade;
import com.medconsultas.medconsultas_api.entity.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private List<Medico> medicos;

    public EspecialidadeDTO(Especialidade especialidade) {
        this.id = especialidade.getId();
        this.titulo = especialidade.getTitulo();
        this.descricao = especialidade.getDescricao();
        this.medicos = especialidade.getMedicos();
    }
}
