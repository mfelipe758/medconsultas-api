package com.medconsultas.medconsultas_api.entity;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha;

    private boolean ativo;
    @ManyToMany
    @JoinTable(
            name = "usuarios_tem_perfis",
            joinColumns = { @JoinColumn(name = "usuario_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "perfil_id", referencedColumnName = "id") }
    )
    private List<Perfil> perfis;
}
