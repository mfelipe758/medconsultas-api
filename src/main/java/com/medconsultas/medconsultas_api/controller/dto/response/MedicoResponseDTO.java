package com.medconsultas.medconsultas_api.controller.dto;
import com.medconsultas.medconsultas_api.entity.*;
import java.time.LocalDate;
import java.util.Set;

public record MedicoResponseDTO(
        Long id,
        String nome,
        String crm,
        LocalDate dataInscricao,
        Set<EspecialidadeResponseDTO> especialidades,
        UsuarioResponseDTO usuario
) {}
