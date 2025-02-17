package net.weg.banco.exceptions;

public class ValorInvalidoException extends ContaException {

    public ValorInvalidoException(){
        super("O valor informado é inválido.");
    }
}
