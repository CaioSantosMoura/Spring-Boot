package net.weg.banco.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ContaController {


    @GetMapping("/ola")
    public String metodoGet() {
        return "Hello World";
    }
}