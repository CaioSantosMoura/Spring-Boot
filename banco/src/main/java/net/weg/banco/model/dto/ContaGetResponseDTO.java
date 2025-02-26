package net.weg.banco.model.dto;

public record ContaGetResponseDTO(
        Integer id,
        Integer numero,
        Double saldo,
        Double limite,
        ClienteContaGetResponseDTO titular) {

}
