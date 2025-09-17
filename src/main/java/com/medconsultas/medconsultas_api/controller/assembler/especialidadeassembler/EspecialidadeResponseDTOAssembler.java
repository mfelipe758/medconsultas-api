package com.medconsultas.medconsultas_api.controller.assembler.especialidadeassembler;

import com.medconsultas.medconsultas_api.controller.dto.response.EspecialidadeResponseDTO;
import com.medconsultas.medconsultas_api.entity.Especialidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EspecialidadeResponseDTOAssembler {
    private final ModelMapper modelMapper;

    public EspecialidadeResponseDTO responseDTO(Especialidade entity) {
        return modelMapper.map(entity, EspecialidadeResponseDTO.class);
    }

    public List<EspecialidadeResponseDTO> responseDTOList(List<Especialidade> entities) {
        return entities.stream().map(this::responseDTO).toList();
    }
}
