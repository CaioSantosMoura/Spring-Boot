package net.weg.banco.model.exceptions;

public class ValorInvalidoException extends ContaException {

    public ValorInvalidoException(){
        super("O valor informado é inválido.");
    }
}
