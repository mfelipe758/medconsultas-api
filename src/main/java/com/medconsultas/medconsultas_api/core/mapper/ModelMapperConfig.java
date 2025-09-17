package com.medconsultas.medconsultas_api.core.mapper;

import com.medconsultas.medconsultas_api.repository.MedicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
