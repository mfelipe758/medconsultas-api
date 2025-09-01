package com.medconsultas.medconsultas_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_cpf", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_crm", nullable = false)
    private Medico medico;

    private LocalDateTime dataHora;
    private String motivo;
}
