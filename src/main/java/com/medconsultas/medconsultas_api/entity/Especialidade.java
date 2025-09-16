package com.medconsultas.medconsultas_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", unique = true, nullable = false)
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @JsonIgnore
    @ManyToMany(mappedBy = "especialidades")
    private List<Medico> medicos;

}
