package com.medconsultas.medconsultas_api.controller.assembler.pacienteassembler;

import com.medconsultas.medconsultas_api.controller.dto.request.PacienteRequestDTO;
import com.medconsultas.medconsultas_api.entity.Paciente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PacienteRequestDTOAssembler {
    private final ModelMapper modelMapper;

    public Paciente requestToEntity(PacienteRequestDTO dto) {
        return modelMapper.map(dto, Paciente.class);
    }
}
