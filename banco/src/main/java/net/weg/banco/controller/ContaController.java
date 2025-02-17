package net.weg.banco.controller;

import lombok.AllArgsConstructor;
import net.weg.banco.model.Conta;
import net.weg.banco.service.ContaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/conta")
public class ContaController {

    ContaService contaService;

    @GetMapping()
    public List<Conta> buscarTodasAsContas() {
        return contaService.buscarContas();
    }

    @GetMapping("/{id}")
    public Conta buscarContaPorId(@PathVariable Integer id) {
        return contaService.buscarConta(id);
    }

    @PostMapping
    public String cadastrarConta(@RequestBody Conta conta) {
        contaService.criarConta(conta);
        return conta.toString();
    }

    @DeleteMapping("/{id}")
    public String removerConta(@PathVariable Integer id) {
        contaService.removerConta(id);
        return "Deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Conta atualizarConta(@RequestBody Integer id ,@RequestBody Conta conta) {
        return contaService.atualizarConta(id, conta);
    }

    @PatchMapping()
    public Conta alterarLimite(@RequestParam Integer id, @RequestParam Double limite) {
        return contaService.alterarLimite(id, limite);
    }
}