package com.medconsultas.medconsultas_api.controller;

import com.medconsultas.medconsultas_api.dto.MedicoDTO;
import com.medconsultas.medconsultas_api.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> criar(@RequestBody MedicoDTO dto) {
        return ResponseEntity.ok(service.adicionarMedico(dto));
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listar() {
        return ResponseEntity.ok(service.listaMedicos());
    }
}
