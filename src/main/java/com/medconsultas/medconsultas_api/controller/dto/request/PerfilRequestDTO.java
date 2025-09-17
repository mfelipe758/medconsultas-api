package com.medconsultas.medconsultas_api.controller.dto.request;

import com.medconsultas.medconsultas_api.entity.PerfilTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerfilRequestDTO {
    private PerfilTipo id;
    private String descricao;
}
