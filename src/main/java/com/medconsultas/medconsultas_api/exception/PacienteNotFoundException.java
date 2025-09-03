package com.medconsultas.medconsultas_api.exception;

public class PacienteNotFoundException extends ResourceNotFoundException {
    public PacienteNotFoundException(String cpf) {
        super("Paciente com CPF " + cpf + " não encontrado");
    }
}
