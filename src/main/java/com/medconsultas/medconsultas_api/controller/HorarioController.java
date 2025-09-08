package com.medconsultas.medconsultas_api.controller;

import com.medconsultas.medconsultas_api.dto.HorarioDTO;
import com.medconsultas.medconsultas_api.service.HorarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioService service;

    public HorarioController(HorarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<HorarioDTO>> listarHorarios(){
        return ResponseEntity.ok(service.listarHorarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioDTO> buscarHorario(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarHorario(id));
    }

    @PostMapping
    public ResponseEntity<HorarioDTO> criarHorario(@RequestBody HorarioDTO horarioDTO){
        return ResponseEntity.ok(service.adicionarHorario(horarioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioDTO> atualizarHorario(@PathVariable Long id, @RequestBody HorarioDTO horarioDTO){
        return ResponseEntity.ok(service.atualizarHorario(id,horarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHorario(@PathVariable Long id){
        service.deletarHorario(id);
        return ResponseEntity.noContent().build();
    }
}
