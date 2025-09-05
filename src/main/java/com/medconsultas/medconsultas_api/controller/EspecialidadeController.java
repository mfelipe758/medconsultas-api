package com.medconsultas.medconsultas_api.controller;

import com.medconsultas.medconsultas_api.dto.EspecialidadeDTO;
import com.medconsultas.medconsultas_api.entity.Especialidade;
import com.medconsultas.medconsultas_api.service.EspecialidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidade")
public class EspecialidadeController {

    private final EspecialidadeService service;

    public EspecialidadeController(EspecialidadeService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<EspecialidadeDTO>> listarEspecialidades(){
        return ResponseEntity.ok(service.listarEspecialidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> buscarEspecialidade(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarEspecialidade(id));
    }

    @PostMapping
    public ResponseEntity<EspecialidadeDTO> criarEspecialidade(@RequestBody EspecialidadeDTO especialidadeDTO){
        return ResponseEntity.ok(service.adicionarEspecialidade(especialidadeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeDTO> atualizarEspecialidade(@PathVariable Long id, @RequestBody EspecialidadeDTO especialidadeDTO){
        return ResponseEntity.ok(service.atualizarEspecialidade(id, especialidadeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEspecialidade(@PathVariable Long id){
        service.deletarEspecialidade(id);
        return ResponseEntity.noContent().build();
    }


}
