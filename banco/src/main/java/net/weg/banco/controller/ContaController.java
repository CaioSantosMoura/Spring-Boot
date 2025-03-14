package net.weg.banco.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.banco.model.dto.ContaPostRequestDTO;
import net.weg.banco.model.dto.ContaPutRequestDTO;
import net.weg.banco.model.dto.ContaResponseDTO;
import net.weg.banco.model.entity.Conta;
import net.weg.banco.service.ContaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Component é uma das anotações que identificam uma classe como a @Service e a @RestController mas generico
@RestController
@RequestMapping("/conta")
@AllArgsConstructor
public class ContaController {

    private ContaService contaService;

    //  @RequestMapping(method = RequestMethod.GET, value = "/ola")
    @GetMapping("/world") // mesma coisa que o de cima só que de uma forma mais simplificada
    public String metodoGet(){
        return "Hello";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta cadastrarConta(@RequestBody @Valid ContaPostRequestDTO contaDTO){
        return contaService.criarConta(contaDTO);
    }

    @GetMapping
    public List<ContaResponseDTO> listarContas(){
        List<Conta> contasList = contaService.buscarContas();
        return contasList.stream().map(Conta::convertToContaResponseDTO).toList();
    }

    @GetMapping("/page")
    public Page<ContaResponseDTO> listarContasPage(
            @PageableDefault(
                    size = 20,
                    sort = "saldo",
                    direction = Sort.Direction.DESC,
                    page = 0
            ) Pageable pageable){
        Page<Conta> contasPage = contaService.buscarContas(pageable);

        List<ContaResponseDTO> contasResponseList = contasPage.stream().map(Conta::convertToContaResponseDTO).toList();
        return new PageImpl<>(contasResponseList, pageable, contasPage.getTotalElements());
    }

    @GetMapping("/{id}")
    public ContaResponseDTO buscarContaPorId(@PathVariable Integer id){
        Conta conta = contaService.buscarConta(id);
        return conta.convert();
    }

    @DeleteMapping("/{id}")
    public void removerConta(@PathVariable Integer id){
        contaService.deletarConta(id);
    }

    @PutMapping("/{id}")
    public ContaResponseDTO atualizarConta(@PathVariable Integer id, @RequestBody ContaPutRequestDTO contaDTO){
        Conta conta = contaService.atualizarConta(id, contaDTO);
        return conta.convert();
    }

    @PatchMapping("/{id}")
    public ContaResponseDTO alterarLimite(@RequestParam Double limite, @PathVariable Integer id){
        Conta conta = contaService.alterarLimite(id, limite);
        return conta.convert();
    }
}