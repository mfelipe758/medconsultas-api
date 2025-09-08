package com.medconsultas.medconsultas_api.service;

import com.medconsultas.medconsultas_api.dto.AgendamentoDTO;
import com.medconsultas.medconsultas_api.entity.Agendamento;
import com.medconsultas.medconsultas_api.exception.AgendamentoNotFoundException;
import com.medconsultas.medconsultas_api.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public AgendamentoDTO adicionarAgendamento(AgendamentoDTO agendamentoDTO ) {
        Agendamento agendamento = Agendamento.builder()
                .especialidade(agendamentoDTO.getEspecialidade())
                .medico(agendamentoDTO.getMedico())
                .paciente(agendamentoDTO.getPaciente())
                .consulta(agendamentoDTO.getConsulta())
                .horario(agendamentoDTO.getHorario())
                .dataConsulta(agendamentoDTO.getDataConsulta())
                .build();
        repository.save(agendamento);
        return new AgendamentoDTO(agendamento);
    }

    public List<AgendamentoDTO> listarAgendamentos(){
        return repository.findAll()
                .stream()
                .map(AgendamentoDTO::new)
                .toList();
    }
    public AgendamentoDTO buscarAgendamento(Long id){
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new AgendamentoNotFoundException(id));
        return new AgendamentoDTO(agendamento);
    }
    public AgendamentoDTO atualizarAgendamento(Long id, AgendamentoDTO agendamentoDTO) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new AgendamentoNotFoundException(id));
        agendamento.setEspecialidade(agendamentoDTO.getEspecialidade());
        agendamento.setMedico(agendamentoDTO.getMedico());
        agendamento.setPaciente(agendamentoDTO.getPaciente());
        agendamento.setConsulta(agendamentoDTO.getConsulta());
        agendamento.setHorario(agendamentoDTO.getHorario());
        agendamento.setDataConsulta(agendamentoDTO.getDataConsulta());
        repository.save(agendamento);
        return new AgendamentoDTO(agendamento);
    }
    public void deletarAgendamento(Long id){
        if (!repository.existsById(id)) {
            throw new AgendamentoNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
