package net.weg.banco.model.dto;

public record ClienteResponseDTO(
        Integer id,
        String nome,
        Long cpf,
        Set<ContaClienteGetResponseDTO> contas) {
}
