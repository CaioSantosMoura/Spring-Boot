package net.weg.banco.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import net.weg.banco.model.entity.Conta;

public record ContaPostRequestDTO(@NotBlank String titular, @Positive @NotNull Integer numero,
                                  @PositiveOrZero Double limite) {

    public Conta convert() {
       return Conta.builder()
                .titular(titular)
                .numero(numero)
                .limite(limite)
                .build();
    }
}
