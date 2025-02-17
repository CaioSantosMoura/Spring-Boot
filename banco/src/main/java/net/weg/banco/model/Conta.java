package net.weg.banco.model;

import lombok.*;

@Data
@Entity
public class Conta {
    @NonNull
    private Integer numero;
    @NonNull
    private Double saldo;
    @NonNull
    private Double limite;
    @NonNull
    private String titular;

}