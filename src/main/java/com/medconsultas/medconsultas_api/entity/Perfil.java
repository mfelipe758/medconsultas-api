package com.medconsultas.medconsultas_api.entity;

import jakarta.persistence.*;

@Entity
public class Perfil {

    @Id
    @Enumerated(EnumType.STRING)
    private PerfilTipo id;

    private String descricao;
}
