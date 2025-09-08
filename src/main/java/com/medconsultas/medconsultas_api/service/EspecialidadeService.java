package com.medconsultas.medconsultas_api.service;

import com.medconsultas.medconsultas_api.dto.EspecialidadeDTO;
import com.medconsultas.medconsultas_api.dto.MedicoDTO;
import com.medconsultas.medconsultas_api.entity.Especialidade;
import com.medconsultas.medconsultas_api.exception.EspecialidadeNotFoundException;
import com.medconsultas.medconsultas_api.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository repository;

    public EspecialidadeService(EspecialidadeRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public EspecialidadeDTO adicionarEspecialidade(EspecialidadeDTO especialidadeDTO) {
        Especialidade especialidade = Especialidade.builder()
                .id(especialidadeDTO.getId())
                .titulo(especialidadeDTO.getTitulo())
                .descricao(especialidadeDTO.getDescricao())
                .medicos(especialidadeDTO.getMedicos())
                .build();
        repository.save(especialidade);
        return new EspecialidadeDTO(especialidade);
    }

    public List<EspecialidadeDTO> listarEspecialidades(){
        return repository.findAll()
                .stream()
                .map(EspecialidadeDTO::new)
                .toList();
    }

    public EspecialidadeDTO buscarEspecialidade(Long id){
        Especialidade especialidade = repository.findById(id)
                .orElseThrow(() -> new EspecialidadeNotFoundException(id));
        return new EspecialidadeDTO(especialidade);
    }

    public EspecialidadeDTO atualizarEspecialidade(Long id, EspecialidadeDTO especialidadeDTO){
        Especialidade especialidade = repository.findById(id)
                .orElseThrow(() -> new EspecialidadeNotFoundException(id));
        especialidade.setTitulo(especialidadeDTO.getTitulo());
        especialidade.setDescricao(especialidadeDTO.getDescricao());
        especialidade.setMedicos(especialidadeDTO.getMedicos());
        repository.save(especialidade);
        return new EspecialidadeDTO(especialidade);
    }
    public void deletarEspecialidade(Long id){
        if(!repository.existsById(id)){
           throw new EspecialidadeNotFoundException(id);
        }
        repository.deleteById(id);
    }
    public void verificarEspecialidadeExistente(MedicoDTO medicoDTO){
        medicoDTO.getEspecialidades()
                .stream()
                .map(Especialidade::getId)
                .forEach(idEspecialidade -> {
                    if (!repository.existsById(idEspecialidade)) {
                        throw new EspecialidadeNotFoundException(idEspecialidade);
                    }
                });
    }
}
