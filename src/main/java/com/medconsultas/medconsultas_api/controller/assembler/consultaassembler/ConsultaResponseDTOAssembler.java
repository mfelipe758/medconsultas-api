package com.medconsultas.medconsultas_api.controller.assembler.consultaassembler;

import com.medconsultas.medconsultas_api.controller.dto.response.ConsultaResponseDTO;
import com.medconsultas.medconsultas_api.entity.Consulta;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsultaResponseDTOAssembler {
    private final ModelMapper modelMapper;

    public ConsultaResponseDTO responseDTO(Consulta entity) {
        return modelMapper.map(entity, ConsultaResponseDTO.class);
    }

    public List<ConsultaResponseDTO> responseDTOList(List<Consulta> entities) {
        return entities.stream().map(this::responseDTO).toList();
    }
}
