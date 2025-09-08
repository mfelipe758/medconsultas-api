package com.medconsultas.medconsultas_api.service;

import com.medconsultas.medconsultas_api.dto.HorarioDTO;
import com.medconsultas.medconsultas_api.entity.Horario;
import com.medconsultas.medconsultas_api.exception.HorarioNotFoundException;
import com.medconsultas.medconsultas_api.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository repository;

    public HorarioService(HorarioRepository repository) {
        this.repository = repository;
    }

    public HorarioDTO adicionarHorario(HorarioDTO horarioDTO) {
        Horario horario = Horario.builder()
                .id(horarioDTO.getId())
                .horaMinuto(horarioDTO.getHoraMinuto())
                .build();
        repository.save(horario);
        return new HorarioDTO(horario);
    }

    public List<HorarioDTO> listarHorarios() {
        return repository.findAll()
                .stream()
                .map(HorarioDTO:: new)
                .toList();
    }

    public HorarioDTO buscarHorario(Long id){
        Horario horario = repository.findById(id).orElseThrow(() -> new HorarioNotFoundException(id));
        return new HorarioDTO(horario);
    }

    public HorarioDTO atualizarHorario(Long id, HorarioDTO horarioDTO) {
        Horario horario = repository.findById(id).orElseThrow(() -> new HorarioNotFoundException(id));
        horario.setHoraMinuto(horarioDTO.getHoraMinuto());
        repository.save(horario);
        return new HorarioDTO(horario);
    }

    public void deletarHorario(Long id) {
        if (!repository.existsById(id)) {
            throw new HorarioNotFoundException(id);
        }
        repository.deleteById(id);
    }

}
