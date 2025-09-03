package com.medconsultas.medconsultas_api.exception;

public class ConsultaNotFoundException extends ResourceNotFoundException {
    public ConsultaNotFoundException(String id) {
        super("Consulta com ID " + id + " não encontrada");
    }
}
