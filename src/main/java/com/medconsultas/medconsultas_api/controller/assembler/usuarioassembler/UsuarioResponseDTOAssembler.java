package com.medconsultas.medconsultas_api.controller.assembler.usuarioassembler;

import com.medconsultas.medconsultas_api.controller.dto.response.UsuarioResponseDTO;
import com.medconsultas.medconsultas_api.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioResponseDTOAssembler {
    private final ModelMapper modelMapper;

    public UsuarioResponseDTO responseDTO(Usuario entity) {
        return modelMapper.map(entity, UsuarioResponseDTO.class);
    }

    public List<UsuarioResponseDTO> responseDTOList(List<Usuario> entities) {
        return entities.stream().map(this::responseDTO).toList();
    }
}
