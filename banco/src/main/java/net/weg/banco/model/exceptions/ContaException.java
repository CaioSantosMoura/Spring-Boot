package net.weg.banco.model.exceptions;

public class ContaException extends RuntimeException {

    public ContaException(String mensagemComplemento){
        super("Não foi possível realizar a operação. " + mensagemComplemento);
    }
}
