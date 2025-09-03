package com.medconsultas.medconsultas_api.service;

import com.medconsultas.medconsultas_api.dto.MedicoDTO;
import com.medconsultas.medconsultas_api.entity.Medico;
import com.medconsultas.medconsultas_api.exception.MedicoNotFoundException;
import com.medconsultas.medconsultas_api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }
    public MedicoDTO adicionarMedico(MedicoDTO medicoDTO) {
        Medico medico = Medico.builder()
                .crm(medicoDTO.getCrm())
                .nome(medicoDTO.getNome())
                .email(medicoDTO.getEmail())
                .especialidade(medicoDTO.getEspecialidade())
                .build();
        repository.save(medico);
        return medicoDTO;
    }
    public List<MedicoDTO> listarMedicos() {
        return repository.findAll()
                .stream()
                .map(m -> {
                    MedicoDTO medicoDto = new MedicoDTO();
                    medicoDto.setCrm(m.getCrm());
                    medicoDto.setNome(m.getNome());
                    medicoDto.setEmail(m.getEmail());
                    medicoDto.setEspecialidade(m.getEspecialidade());
                    return medicoDto;
                })
                .collect(Collectors.toList());
    }
    public MedicoDTO BuscarPorCrm(String crm) {
        Medico m = repository.findById(crm)
                .orElseThrow(() -> new MedicoNotFoundException(crm));
        return new MedicoDTO(
                m.getCrm(),
                m.getNome(),
                m.getEmail(),
                m.getEspecialidade()
        );
    }
    public MedicoDTO atualizarMedico(String crm, MedicoDTO medicoDTO) {
        Optional<Medico> medico = repository.findById(crm);
        if (medico.isPresent()) {
            medico.get().setNome(medicoDTO.getNome());
            medico.get().setEspecialidade(medicoDTO.getEspecialidade());
            medico.get().setEmail(medicoDTO.getEmail());
            repository.save(medico.get());
        } else
            throw new MedicoNotFoundException(crm);
        return medicoDTO;
    }
    public void deletarMedico(String crm) {
        if(!repository.existsById(crm)){
            throw new MedicoNotFoundException(crm);
        }
        repository.deleteById(crm);
    }
}
