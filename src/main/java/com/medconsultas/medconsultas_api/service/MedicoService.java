package com.medconsultas.medconsultas_api.service;

import com.medconsultas.medconsultas_api.dto.MedicoDTO;
import com.medconsultas.medconsultas_api.entity.Medico;
import com.medconsultas.medconsultas_api.exception.MedicoNotFoundException;
import com.medconsultas.medconsultas_api.repository.MedicoRepository;
import org.springframework.stereotype.Service;
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
                .map(m -> new MedicoDTO(
                            m.getCrm(),
                            m.getNome(),
                            m.getEmail(),
                            m.getEspecialidade()
                    ))
                .collect(Collectors.toList());
    }
    public MedicoDTO buscarPorCrm(String crm) {
        Medico medico = repository.findById(crm)
                .orElseThrow(() -> new MedicoNotFoundException(crm));
        return new MedicoDTO(
                medico.getCrm(),
                medico.getNome(),
                medico.getEmail(),
                medico.getEspecialidade()
        );
    }
    public MedicoDTO atualizarMedico(String crm, MedicoDTO medicoDTO) {
        Medico medico = repository.findById(crm)
                .orElseThrow(() -> new MedicoNotFoundException(crm));
        medico.setNome(medicoDTO.getNome());
        medico.setEspecialidade(medicoDTO.getEspecialidade());
        medico.setEmail(medicoDTO.getEmail());
        repository.save(medico);
        return new MedicoDTO(
                medico.getCrm(),
                medico.getNome(),
                medico.getEmail(),
                medico.getEspecialidade()
        );
    }

    public void deletarMedico(String crm) {
        if(!repository.existsById(crm)){
            throw new MedicoNotFoundException(crm);
        }
        repository.deleteById(crm);
    }
}
