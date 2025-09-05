package com.medconsultas.medconsultas_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medconsultas.medconsultas_api.dto.ConsultaDTO;
import com.medconsultas.medconsultas_api.service.ConsultaService;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> listarConsultas() {
        return ResponseEntity.ok(service.listarConsultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscarConsulta(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarConsulta(id));
    }

    @PostMapping
    public ResponseEntity<ConsultaDTO> criarConsulta(@RequestBody ConsultaDTO consultaDTO) {
        return ResponseEntity.ok(service.adicionarConsulta(consultaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaDTO consultaDTO) {
        return ResponseEntity.ok(service.atualizarConsulta(id, consultaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        service.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
