package net.weg.banco.model;

import lombok.*;
import net.weg.banco.exceptions.*;

@Data
@AllArgsConstructor
public class Conta {
    @NonNull
    private int numero;
    @NonNull
    private double saldo;
    private double limite;
    public String titular;

}