package net.weg.banco.model.exceptions;

public class LimiteInsuficienteException extends ContaException {

    public LimiteInsuficienteException() {
        super("Limite insuficiente.");
    }
}
