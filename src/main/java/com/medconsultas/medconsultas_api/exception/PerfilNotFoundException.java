package com.medconsultas.medconsultas_api.exception;

public class PerfilNotFoundException extends ResourceNotFoundException {
    public PerfilNotFoundException(Long id) {
        super("Perfil com ID " + id + " não encontrado");
    }
}
