package com.medconsultas.medconsultas_api.controller.assembler.agendamentoassembler;

import com.medconsultas.medconsultas_api.controller.dto.request.AgendamentoRequestDTO;
import com.medconsultas.medconsultas_api.entity.Agendamento;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgendamentoRequestDTOAssembler {
    private final ModelMapper modelMapper;

    public Agendamento requestToEntity(AgendamentoRequestDTO dto) {
        return modelMapper.map(dto, Agendamento.class);
    }
}
