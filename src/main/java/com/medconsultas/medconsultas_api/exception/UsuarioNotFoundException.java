package com.medconsultas.medconsultas_api.exception;

public class UsuarioNotFoundException extends ResourceNotFoundException {

    public UsuarioNotFoundException(Long id) {
        super("Usuario com ID " + id + " não encontrado");
    }
}
