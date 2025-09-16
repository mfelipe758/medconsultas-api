package com.medconsultas.medconsultas_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_especialidade", nullable = false)
    private Especialidade especialidade;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @OneToOne(mappedBy = "agendamento", cascade = CascadeType.ALL)
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_consulta", nullable = false)
    private LocalDate dataConsulta;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusAgendamento status;
}
