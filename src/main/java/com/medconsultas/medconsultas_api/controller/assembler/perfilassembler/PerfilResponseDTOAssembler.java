package com.medconsultas.medconsultas_api.controller.assembler.perfilassembler;

import com.medconsultas.medconsultas_api.controller.dto.response.PerfilResponseDTO;
import com.medconsultas.medconsultas_api.entity.Perfil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PerfilResponseDTOAssembler {
    private final ModelMapper modelMapper;

    public PerfilResponseDTO responseDTO(Perfil entity) {
        return modelMapper.map(entity, PerfilResponseDTO.class);
    }

    public List<PerfilResponseDTO> responseDTOList(List<Perfil> entities) {
        return entities.stream().map(this::responseDTO).toList();
    }
}
