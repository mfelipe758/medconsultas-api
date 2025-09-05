package com.medconsultas.medconsultas_api.exception;

public class MedicoNotFoundException extends ResourceNotFoundException {

    public MedicoNotFoundException(Long id) {
        super("Médico com ID " + id + " não encontrado");
    }
}
