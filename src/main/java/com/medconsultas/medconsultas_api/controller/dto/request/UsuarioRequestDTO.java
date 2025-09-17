package com.medconsultas.medconsultas_api.controller.dto.request;

import com.medconsultas.medconsultas_api.entity.PerfilTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioRequestDTO {
    private String email;
    private String senha;
    private boolean ativo;
    private List<PerfilTipo> perfis;
}
