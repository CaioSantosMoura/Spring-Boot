package net.weg.banco.model.dto;

import net.weg.banco.model.entity.Conta;

import java.util.List;

public record ClientePutRequestDTO(String nome, Long cpf, List<Conta> contas) {

}
