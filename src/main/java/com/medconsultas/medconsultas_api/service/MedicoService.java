package com.medconsultas.medconsultas_api.service;

import com.medconsultas.medconsultas_api.dto.MedicoDTO;
import com.medconsultas.medconsultas_api.entity.Especialidade;
import com.medconsultas.medconsultas_api.entity.Medico;
import com.medconsultas.medconsultas_api.exception.EspecialidadeNotFoundException;
import com.medconsultas.medconsultas_api.exception.MedicoNotFoundException;
import com.medconsultas.medconsultas_api.repository.EspecialidadeRepository;
import com.medconsultas.medconsultas_api.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    private final MedicoRepository repository;
    private final EspecialidadeService serviceEspecialidade;

    public MedicoService(MedicoRepository repository, EspecialidadeService serviceEspecialidade) {
        this.repository = repository;
        this.serviceEspecialidade = serviceEspecialidade;
    }

    @Transactional
    public MedicoDTO adicionarMedico(MedicoDTO medicoDTO) {

       serviceEspecialidade.verificarEspecialidadeExistente(medicoDTO);

        Medico medico = Medico.builder()
                .id(medicoDTO.getId())
                .nome(medicoDTO.getNome())
                .crm(medicoDTO.getCrm())
                .dataInscricao(medicoDTO.getDataInscricao())
                .especialidades(medicoDTO.getEspecialidades())
                .build();
        repository.save(medico);
        return medicoDTO;
    }
    public List<MedicoDTO> listarMedicos() {
        return repository.findAll()
                .stream()
                .map(MedicoDTO::new)
                .toList();
    }
    public MedicoDTO buscarMedico(Long id) {
        Medico medico = repository.findById(id)
                .orElseThrow(() -> new MedicoNotFoundException(id));
        return new MedicoDTO(
                medico.getId(),
                medico.getNome(),
                medico.getCrm(),
                medico.getDataInscricao(),
                medico.getEspecialidades()
        );
    }
    public MedicoDTO atualizarMedico(Long id, MedicoDTO medicoDTO) {
        Medico medico = repository.findById(id)
                .orElseThrow(() -> new MedicoNotFoundException(id));
        medico.setNome(medicoDTO.getNome());
        medico.setCrm(medicoDTO.getCrm());
        medico.setDataInscricao(medicoDTO.getDataInscricao());
        medico.setEspecialidades(medicoDTO.getEspecialidades());
        repository.save(medico);
        return new MedicoDTO(
                medico.getId(),
                medico.getNome(),
                medico.getCrm(),
                medico.getDataInscricao(),
                medico.getEspecialidades()
        );
    }

    public void deletarMedico(Long id) {
        if(!repository.existsById(id)){
            throw new MedicoNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
