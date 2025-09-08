package com.medconsultas.medconsultas_api.controller;

import com.medconsultas.medconsultas_api.dto.MedicoDTO;
import com.medconsultas.medconsultas_api.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarMedicos() {
        return ResponseEntity.ok(service.listarMedicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarMedico(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarMedico(id));
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> criarMedico(@RequestBody MedicoDTO medicoDTO) {
        return ResponseEntity.ok(service.adicionarMedico(medicoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> atualizarMedico(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO) {
        return ResponseEntity.ok(service.atualizarMedico(id, medicoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        service.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }

}
