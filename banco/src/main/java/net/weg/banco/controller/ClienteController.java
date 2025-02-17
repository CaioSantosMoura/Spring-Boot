package net.weg.banco.controller;

public class ClienteController {

    private int id;
    private String nome;
    private String cpf;
    private ContaController conta;

    public ClienteController(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
    }
}