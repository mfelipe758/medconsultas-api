package com.medconsultas.medconsultas_api.service;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.medconsultas.medconsultas_api.dto.PacienteDTO;
import com.medconsultas.medconsultas_api.entity.Paciente;
import com.medconsultas.medconsultas_api.exception.PacienteNotFoundException;
import com.medconsultas.medconsultas_api.repository.PacienteRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public PacienteDTO adicionarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = Paciente.builder()
                .id(pacienteDTO.getId())
                .nome(pacienteDTO.getNome())
                .dataNascimento(pacienteDTO.getDataNascimento())
                .consultas(pacienteDTO.getConsultas())
                .build();
        repository.save(paciente);
        return new PacienteDTO(paciente);
    }

    public List<PacienteDTO> listarPacientes() {
        return repository.findAll()
                .stream()
                .map(PacienteDTO::new)
                .toList();
    }
    
    public PacienteDTO buscar(Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));
        return new PacienteDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getDataNascimento(),
                paciente.getConsultas());
    }
    
    
    public PacienteDTO atualizarPaciente(Long id, PacienteDTO pacienteDTO) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));
        paciente.setNome(pacienteDTO.getNome());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setConsultas(pacienteDTO.getConsultas());
        repository.save(paciente);
        return new PacienteDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getDataNascimento(),
                paciente.getConsultas()
        );
    }
    
    public void deletarPaciente(Long id) {
        if (!repository.existsById(id)) {
            throw new PacienteNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
