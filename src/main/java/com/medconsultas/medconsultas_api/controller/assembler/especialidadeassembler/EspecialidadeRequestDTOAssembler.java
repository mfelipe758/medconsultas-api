package com.medconsultas.medconsultas_api.controller.assembler.especialidadeassembler;

import com.medconsultas.medconsultas_api.controller.dto.request.EspecialidadeRequestDTO;
import com.medconsultas.medconsultas_api.entity.Especialidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EspecialidadeRequestDTOAssembler {
    private final ModelMapper modelMapper;

    public Especialidade requestToEntity(EspecialidadeRequestDTO dto) {
        return modelMapper.map(dto, Especialidade.class);
    }
}
