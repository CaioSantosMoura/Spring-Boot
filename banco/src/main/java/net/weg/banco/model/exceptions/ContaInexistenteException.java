package net.weg.banco.model.exceptions;

public class ContaInexistenteException extends ContaException {

    public ContaInexistenteException() {
        super("Não foi informada uma conta existente.");
    }
}
