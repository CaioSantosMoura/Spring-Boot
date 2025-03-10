package net.weg.banco.model.exceptions;

public class ContaJaCadastradaException extends ContaException {
    public ContaJaCadastradaException() {
        super("Já existe uma conta cadastrada com número informado!");
    }
}
