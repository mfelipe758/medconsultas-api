package com.medconsultas.medconsultas_api.exception;

public class ConsultaNotFoundException extends RuntimeException {
    public ConsultaNotFoundException(String id) {
        super("Consulta com ID " + id + " não encontrada");
    }
}
