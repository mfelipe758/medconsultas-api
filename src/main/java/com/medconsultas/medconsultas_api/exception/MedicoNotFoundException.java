package com.medconsultas.medconsultas_api.exception;

public class MedicoNotFoundException extends ResourceNotFoundException {

    public MedicoNotFoundException(String crm) {
        super("Médico com CRM " + crm + " não encontrado");
    }
}
