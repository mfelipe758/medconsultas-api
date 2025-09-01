package com.medconsultas.medconsultas_api.exception;

public class MedicoNotFoundException extends RuntimeException {
    public MedicoNotFoundException(String crm) {
        super("Médico com CRM " + crm + " não encontrado");
    }
}
