package net.weg.banco.controller;

import net.weg.banco.model.Conta;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {


    @GetMapping("/ola")
    public String metodoGet() {
        return "Hello World";
    }

    @PostMapping
    public String cadastrarConta(@RequestBody Conta conta) {

    }
}