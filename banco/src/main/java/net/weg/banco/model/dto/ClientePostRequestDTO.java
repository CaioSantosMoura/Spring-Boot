package net.weg.banco.model.dto;

import net.weg.banco.model.entity.Cliente;

public record ClientePostRequestDTO(String nome, Long cpf) {
    public Cliente convert() {
        return Cliente.builder().nome(nome).cpf(cpf).build();
    }
}