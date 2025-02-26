package net.weg.banco.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import net.weg.banco.model.entity.Cliente;
import net.weg.banco.model.entity.Conta;

import java.util.List;

public record ContaPostRequestDTO(
        Cliente titular,
        @Positive @NotNull Integer numero,
        @PositiveOrZero Double limite) {

    public Conta convert() {
       return Conta.builder()
                .cliente(titular)
                .numero(numero)
                .limite(limite)
                .build();
    }
}
