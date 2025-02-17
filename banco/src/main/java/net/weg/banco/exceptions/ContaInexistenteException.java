package net.weg.banco.exceptions;

public class ContaInexistenteException extends ContaException {

    public ContaInexistenteException() {
        super("Não foi informada uma conta existente.");
    }
}
