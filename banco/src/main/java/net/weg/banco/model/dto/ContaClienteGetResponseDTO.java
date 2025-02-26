package net.weg.banco.model.dto;

public record ContaClienteGetResponseDTO(
        Integer id,
        Double saldo,
        Double limite,
        Integer numero) {
}
