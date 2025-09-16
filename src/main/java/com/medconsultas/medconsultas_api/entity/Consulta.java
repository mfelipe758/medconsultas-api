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

    @OneToOne
    @JoinColumn(name = "id_agendamento", nullable = false)
    private Agendamento agendamento;

    private LocalDateTime dataHoraRealizada;

    private String diagnostico;

    private String observacoes;

    private String receita;
}
