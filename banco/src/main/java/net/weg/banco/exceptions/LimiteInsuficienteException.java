package net.weg.banco.exceptions;

public class LimiteInsuficienteException extends ContaException {

    public LimiteInsuficienteException() {
        super("Limite insuficiente.");
    }
}
