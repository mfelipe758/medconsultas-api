package com.medconsultas.medconsultas_api.controller.assembler.pacienteassembler;

import com.medconsultas.medconsultas_api.controller.dto.response.PacienteResponseDTO;
import com.medconsultas.medconsultas_api.entity.Paciente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PacienteResponseDTOAssembler {
    private final ModelMapper modelMapper;

    public PacienteResponseDTO responseDTO(Paciente entity) {
        return modelMapper.map(entity, PacienteResponseDTO.class);
    }

    public List<PacienteResponseDTO> responseDTOList(List<Paciente> entities) {
        return entities.stream().map(this::responseDTO).toList();
    }
}
