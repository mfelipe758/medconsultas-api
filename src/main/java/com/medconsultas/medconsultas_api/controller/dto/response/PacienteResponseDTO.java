package com.medconsultas.medconsultas_api.controller.dto.response;

import com.medconsultas.medconsultas_api.entity.Endereco;

import java.time.LocalDate;

public record PacienteResponseDTO(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        Endereco endereco,
        UsuarioResponseDTO usuario
) {}
