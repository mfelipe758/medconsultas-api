package com.medconsultas.medconsultas_api.controller.dto.response;

import com.medconsultas.medconsultas_api.entity.PerfilTipo;

import java.util.List;

public record UsuarioResponseDTO(
        Long id,
        String email,
        boolean ativo,
        List<PerfilTipo> perfis
) {}
