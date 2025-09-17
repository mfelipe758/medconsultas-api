package com.medconsultas.medconsultas_api.controller.assembler.medicoassembler;

import com.medconsultas.medconsultas_api.controller.dto.response.MedicoResponseDTO;
import com.medconsultas.medconsultas_api.entity.Medico;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MedicoResponseDTOAssembler {

    private final ModelMapper modelMapper;

    public MedicoResponseDTO responseDTO (Medico entity) {
        return modelMapper.map(entity, MedicoResponseDTO.class);
    }

    public List<MedicoResponseDTO> responseDTOList (List<Medico> entities){
        return entities.stream().map(this::responseDTO).toList();
    }

}
