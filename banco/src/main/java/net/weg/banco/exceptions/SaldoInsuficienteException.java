package net.weg.banco.exceptions;

public class SaldoInsuficienteException extends ContaException {

    public SaldoInsuficienteException(){
        super("Saldo insuficiente.");
    }
}
