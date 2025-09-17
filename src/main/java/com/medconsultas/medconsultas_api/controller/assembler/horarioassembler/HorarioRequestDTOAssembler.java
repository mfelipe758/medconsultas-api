package com.medconsultas.medconsultas_api.controller.assembler.horarioassembler;

import com.medconsultas.medconsultas_api.controller.dto.request.HorarioRequestDTO;
import com.medconsultas.medconsultas_api.entity.Horario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HorarioRequestDTOAssembler {
    private final ModelMapper modelMapper;

    public Horario requestToEntity(HorarioRequestDTO dto) {
        return modelMapper.map(dto, Horario.class);
    }
}
