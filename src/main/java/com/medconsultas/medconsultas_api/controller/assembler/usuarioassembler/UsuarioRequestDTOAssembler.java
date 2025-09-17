package com.medconsultas.medconsultas_api.controller.assembler.usuarioassembler;

import com.medconsultas.medconsultas_api.controller.dto.request.UsuarioRequestDTO;
import com.medconsultas.medconsultas_api.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioRequestDTOAssembler {
    private final ModelMapper modelMapper;

    public Usuario requestToEntity(UsuarioRequestDTO dto) {
        return modelMapper.map(dto, Usuario.class);
    }
}
