package com.medconsultas.medconsultas_api.exception;

public class PacienteNotFoundException extends ResourceNotFoundException {
    public PacienteNotFoundException(Long id) {
        super("Paciente com ID " + id + " não encontrado");
    }
}
