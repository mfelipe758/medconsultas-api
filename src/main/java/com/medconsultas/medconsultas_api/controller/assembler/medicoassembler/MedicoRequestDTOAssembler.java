package com.medconsultas.medconsultas_api.controller.assembler.medicoassembler;

import com.medconsultas.medconsultas_api.controller.dto.request.MedicoRequestDTO;
import com.medconsultas.medconsultas_api.entity.Medico;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicoRequestDTOAssembler {

    private final ModelMapper modelMapper;

   public Medico requestToEntity(MedicoRequestDTO dto){
       return modelMapper.map(dto, Medico.class);
   }
}
