package com.medconsultas.medconsultas_api.exception;

public class AgendamentoNotFoundException extends ResourceNotFoundException {

    public AgendamentoNotFoundException(Long id) {
        super("Agendamento com ID " + id + " não encontrado");
    }
}
