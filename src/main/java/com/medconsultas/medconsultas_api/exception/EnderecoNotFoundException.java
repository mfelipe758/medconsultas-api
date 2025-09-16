package com.medconsultas.medconsultas_api.exception;

public class EnderecoNotFoundException extends ResourceNotFoundException {
    public EnderecoNotFoundException(Long id) {
        super("Endereço com ID " + id + " não encontrado");
    }
}
