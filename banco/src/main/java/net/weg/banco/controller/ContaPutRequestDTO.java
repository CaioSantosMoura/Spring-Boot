package net.weg.banco.controller;

import net.weg.banco.model.entity.Conta;

public class ContaPutRequestDTO {
    public Conta convert() {
        return new Conta();
    }
}
