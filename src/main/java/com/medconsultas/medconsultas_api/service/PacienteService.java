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

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }
    
    public PacienteDTO adicionarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = Paciente.builder()
                .cpf(pacienteDTO.getCpf())
                .nome(pacienteDTO.getNome())
                .email(pacienteDTO.getEmail())
                .build();
        repository.save(paciente);
        return pacienteDTO;
    }

    public List<PacienteDTO> listarPacientes() {
        return repository.findAll()
                .stream()
                .map(p -> new PacienteDTO(
                        p.getCpf(),
                        p.getNome(),
                        p.getEmail()    
                ))
                .collect(Collectors.toList());
    }
    
    public PacienteDTO buscarPorCpf(String cpf) {
        Paciente paciente = repository.findById(cpf)
                .orElseThrow(() -> new PacienteNotFoundException(cpf));
        return new PacienteDTO(
                paciente.getCpf(),
                paciente.getNome(),
                paciente.getEmail());
    }
    
    
    public PacienteDTO atualizarPaciente(String cpf, PacienteDTO pacienteDTO) {
        Paciente paciente = repository.findById(cpf)
                .orElseThrow(() -> new PacienteNotFoundException(cpf));
        paciente.setNome(pacienteDTO.getNome());
        paciente.setEmail(pacienteDTO.getEmail());
        repository.save(paciente);
        return new PacienteDTO(
                paciente.getCpf(),
                paciente.getNome(),
                paciente.getEmail()
        );
    }
    
    public void deletarPaciente(String cpf) {
        if (!repository.existsById(cpf)) {
            throw new PacienteNotFoundException(cpf);
        }
        repository.deleteById(cpf);
    }
}
