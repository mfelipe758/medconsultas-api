package com.medconsultas.medconsultas_api.service;
import com.medconsultas.medconsultas_api.dto.ConsultaDTO;
import com.medconsultas.medconsultas_api.entity.Consulta;
import com.medconsultas.medconsultas_api.exception.ConsultaNotFoundException;
import com.medconsultas.medconsultas_api.repository.ConsultaRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ConsultaDTO adicionarConsulta(ConsultaDTO consultaDTO) {
        Consulta consulta = Consulta.builder()
        .id(consultaDTO.getId())
        .dataHora(consultaDTO.getDataHora())
        .build();
        repository.save(consulta);
        return consultaDTO;
    }

    public List<ConsultaDTO> listarConsultas() {
        return repository.findAll()
                .stream()
                .map(ConsultaDTO::new)
                .toList();
    }

    public ConsultaDTO buscarConsulta(Long id) {
        Consulta consulta = repository.findById(id)
                .orElseThrow(() -> new ConsultaNotFoundException(id));
        return new ConsultaDTO(consulta);
    }
    
    public ConsultaDTO atualizarConsulta(Long id, ConsultaDTO consultaDTO) {
        Consulta consulta = repository.findById(id)
                .orElseThrow(() -> new ConsultaNotFoundException(id));
        consulta.setDataHora(consultaDTO.getDataHora());
        repository.save(consulta);
        return new ConsultaDTO(consulta);
    }

    public void deletarConsulta(Long id) {
        if (!repository.existsById(id)) {
            throw new ConsultaNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
