package net.weg.banco.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import net.weg.banco.model.entity.Cliente;
import net.weg.banco.model.entity.Conta;

public record ContaPutRequestDTO(@NotNull Cliente titular, @PositiveOrZero Double limite) {

    public Conta convert() {
        return Conta.builder().titular(titular).limite(limite).build();
    }
}