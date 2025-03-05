package net.weg.banco.model.dto;

import java.util.List;

public record ClienteResponseDTO(
        Integer id,
        String nome,
        Long cpf,
        List<ContaClienteGetResponseDTO> contas) {
}
