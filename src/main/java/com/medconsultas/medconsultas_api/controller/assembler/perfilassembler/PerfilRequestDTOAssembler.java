package com.medconsultas.medconsultas_api.controller.assembler.perfilassembler;

import com.medconsultas.medconsultas_api.controller.dto.request.PerfilRequestDTO;
import com.medconsultas.medconsultas_api.entity.Perfil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PerfilRequestDTOAssembler {
    private final ModelMapper modelMapper;

    public Perfil requestToEntity(PerfilRequestDTO dto) {
        return modelMapper.map(dto, Perfil.class);
    }
}
