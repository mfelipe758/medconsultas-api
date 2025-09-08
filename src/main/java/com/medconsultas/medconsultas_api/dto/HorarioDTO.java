package com.medconsultas.medconsultas_api.dto;

import com.medconsultas.medconsultas_api.entity.Horario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioDTO {

    private Long id;
    private LocalTime horaMinuto;

    public HorarioDTO(Horario horario) {
        this.id = horario.getId();
        this.horaMinuto = horario.getHoraMinuto();
    }
}
