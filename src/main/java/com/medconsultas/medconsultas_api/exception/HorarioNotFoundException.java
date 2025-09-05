package com.medconsultas.medconsultas_api.exception;

public class HorarioNotFoundException extends ResourceNotFoundException {

    public HorarioNotFoundException(Long id) {
        super("Horario com ID " + id + " não encontrado");
    }
}
