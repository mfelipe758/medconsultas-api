package com.medconsultas.medconsultas_api.controller.assembler.consultaassembler;

import com.medconsultas.medconsultas_api.controller.dto.request.ConsultaRequestDTO;
import com.medconsultas.medconsultas_api.entity.Consulta;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsultaRequestDTOAssembler {
    private final ModelMapper modelMapper;

    public Consulta requestToEntity(ConsultaRequestDTO dto) {
        return modelMapper.map(dto, Consulta.class);
    }
}
