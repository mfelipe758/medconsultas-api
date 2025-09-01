package com.medconsultas.medconsultas_api.exception;

public class PacienteNotFoundException extends RuntimeException {
    public PacienteNotFoundException(String cpf) {
        super("Paciente com CPF " + cpf + " não encontrado");
    }
}
