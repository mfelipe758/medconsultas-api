package com.medconsultas.medconsultas_api.controller.assembler.horarioassembler;

import com.medconsultas.medconsultas_api.controller.dto.response.HorarioResponseDTO;
import com.medconsultas.medconsultas_api.entity.Horario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HorarioResponseDTOAssembler {
    private final ModelMapper modelMapper;

    public HorarioResponseDTO responseDTO(Horario entity) {
        return modelMapper.map(entity, HorarioResponseDTO.class);
    }

    public List<HorarioResponseDTO> responseDTOList(List<Horario> entities) {
        return entities.stream().map(this::responseDTO).toList();
    }
}
