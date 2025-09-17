package com.medconsultas.medconsultas_api.controller.dto.response;

import com.medconsultas.medconsultas_api.entity.PerfilTipo;

public record PerfilResponseDTO(
        PerfilTipo id,
        String descricao
) {}
