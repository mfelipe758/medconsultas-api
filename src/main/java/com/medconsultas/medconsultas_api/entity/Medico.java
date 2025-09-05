package com.medconsultas.medconsultas_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "crm", unique = true, nullable = false)
    private Integer crm;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_inscricao", nullable = false)
    private LocalDate dataInscricao;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "medicos_tem_especialidades",
            joinColumns = @JoinColumn(name = "id_medico", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidade", referencedColumnName = "id")
    )
    private Set<Especialidade> especialidades;

}
