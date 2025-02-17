package net.weg.banco.exceptions;

public class ContaJaCadastradaException extends ContaException {
    public ContaJaCadastradaException() {
        super("Já existe uma conta cadastrada com número informado!");
    }
}
