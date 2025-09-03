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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listarPacientes() {
        return ResponseEntity.ok(service.listarPacientes());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PacienteDTO> buscarPaciente(@PathVariable String cpf) {
        return ResponseEntity.ok(service.buscarPorCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> criarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(service.adicionarPaciente(pacienteDTO));
    }
    
    @PutMapping("/{cpf}")
    public ResponseEntity<PacienteDTO> atualizarPaciente(@PathVariable String cpf, @RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(service.atualizarPaciente(cpf, pacienteDTO));
    }
    
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable String cpf) {
        service.deletarPaciente(cpf);
        return ResponseEntity.noContent().build();
    }


}
