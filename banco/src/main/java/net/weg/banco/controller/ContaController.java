package net.weg.banco.controller;

import lombok.AllArgsConstructor;
import net.weg.banco.model.Conta;
import net.weg.banco.service.ContaService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/conta")
public class ContaController {

    ContaService contaService;

    @GetMapping("/ola")
    public String metodoGet() {
        return "Hello World";
    }

    @PostMapping
    public String cadastrarConta(@RequestBody Conta conta) {
        contaService.criarConta(conta);
        return conta.toString();
    }
}