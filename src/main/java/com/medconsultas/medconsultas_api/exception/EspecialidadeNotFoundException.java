package com.medconsultas.medconsultas_api.exception;

public class EspecialidadeNotFoundException extends ResourceNotFoundException {

    public EspecialidadeNotFoundException(Long id) {
        super("Especialidade com ID " + id + " não encontrado");
    }
}
