package net.weg.banco.model.exceptions;

public class SaldoInsuficienteException extends ContaException {

    public SaldoInsuficienteException(){
        super("Saldo insuficiente.");
    }
}
