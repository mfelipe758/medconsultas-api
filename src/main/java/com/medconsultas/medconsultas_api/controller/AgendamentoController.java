package com.medconsultas.medconsultas_api.controller;

import com.medconsultas.medconsultas_api.dto.AgendamentoDTO;
import com.medconsultas.medconsultas_api.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> listarConsultas() {
        return ResponseEntity.ok(service.listarAgendamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> buscarConsulta(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarAgendamento(id));
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> criarConsulta(@RequestBody AgendamentoDTO agendamentoDTO) {
        return ResponseEntity.ok(service.adicionarAgendamento(agendamentoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> atualizarConsulta(@PathVariable Long id, @RequestBody AgendamentoDTO agendamentoDTO) {
        return ResponseEntity.ok(service.atualizarAgendamento(id, agendamentoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        service.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}
