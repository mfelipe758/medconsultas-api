package com.medconsultas.medconsultas_api.controller;

import com.medconsultas.medconsultas_api.dto.MedicoDTO;
import com.medconsultas.medconsultas_api.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarMedicos() {
        return ResponseEntity.ok(service.listarMedicos());
    }

    @GetMapping("/{crm}")
    public ResponseEntity<MedicoDTO> buscarMedico(@PathVariable String crm) {
        return ResponseEntity.ok(service.buscarPorCrm(crm));
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> criarMedico(@RequestBody MedicoDTO medicoDTO) {
        return ResponseEntity.ok(service.adicionarMedico(medicoDTO));
    }

    @PutMapping("/{crm}")
    public ResponseEntity<MedicoDTO> atualizarMedico(@PathVariable String crm, @RequestBody MedicoDTO medicoDTO) {
        return ResponseEntity.ok(service.atualizarMedico(crm, medicoDTO));
    }

    @DeleteMapping("/{crm}")
    public ResponseEntity<Void> deletarMedico(@PathVariable String crm) {
        service.deletarMedico(crm);
        return ResponseEntity.noContent().build();
    }

}
