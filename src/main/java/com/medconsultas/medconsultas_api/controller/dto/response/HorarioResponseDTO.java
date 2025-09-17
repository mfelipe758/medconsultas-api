package com.medconsultas.medconsultas_api.controller.dto.response;

import java.time.LocalTime;

public record HorarioResponseDTO(
        Long id,
        LocalTime horaMinuto
) {}
