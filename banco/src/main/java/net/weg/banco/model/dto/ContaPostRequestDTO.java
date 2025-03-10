package net.weg.banco.model.dto;

import jakarta.validation.constraints.*;
import net.weg.banco.model.entity.Cliente;
import net.weg.banco.model.entity.Conta;


public record ContaPostRequestDTO(@NotNull Cliente titular, @Positive @NotNull Integer numero,
                                  @PositiveOrZero Double limite) {

    public Conta convert() {
        return Conta.builder().titular(titular).numero(numero).limite(limite).build();
    }
}