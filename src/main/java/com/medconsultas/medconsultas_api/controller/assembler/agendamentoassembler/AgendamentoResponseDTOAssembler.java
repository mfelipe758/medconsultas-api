package com.medconsultas.medconsultas_api.controller.assembler.agendamentoassembler;

import com.medconsultas.medconsultas_api.controller.dto.response.AgendamentoResponseDTO;
import com.medconsultas.medconsultas_api.entity.Agendamento;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AgendamentoResponseDTOAssembler {
    private final ModelMapper modelMapper;

    public AgendamentoResponseDTO responseDTO(Agendamento entity) {
        return modelMapper.map(entity, AgendamentoResponseDTO.class);
    }

    public List<AgendamentoResponseDTO> responseDTOList(List<Agendamento> entities) {
        return entities.stream().map(this::responseDTO).toList();
    }
}
