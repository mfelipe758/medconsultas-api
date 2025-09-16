package com.medconsultas.medconsultas_api.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String cep;
    private String estado;
    private String cidade;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;

}
