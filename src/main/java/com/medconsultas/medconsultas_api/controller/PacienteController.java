package com.medconsultas.medconsultas_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medconsultas.medconsultas_api.dto.PacienteDTO;
import com.medconsultas.medconsultas_api.service.PacienteService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listarPacientes() {
        return ResponseEntity.ok(service.listarPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPaciente(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> criarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(service.adicionarPaciente(pacienteDTO));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> atualizarPaciente(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(service.atualizarPaciente(id, pacienteDTO));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        service.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
