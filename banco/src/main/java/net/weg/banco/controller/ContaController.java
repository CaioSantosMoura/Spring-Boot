package net.weg.banco.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.banco.model.dto.ContaGetResponseDTO;
import net.weg.banco.model.dto.ContaPostRequestDTO;
import net.weg.banco.model.entity.Conta;
import net.weg.banco.service.ContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/conta")
public class ContaController {

    ContaService contaService;

    @GetMapping
    public List<Conta> buscarTodasAsContas() {
        return contaService.buscarContas();
    }

    @GetMapping("/page")
    public Page<Conta> buscarTodasAsContas(
            @PageableDefault(size = 20,
                             sort = "saldo",
                             direction = Sort.Direction.DESC,
                             page = 0
    ) Pageable pageable) {
        return contaService.buscarContas(pageable);
    }

    @GetMapping("/{id}")
    public ContaGetResponseDTO buscarContaPorId(@PathVariable Integer id) {
        Conta conta = contaService.buscarConta(id);
        ContaGetResponseDTO responseDTO = new ContaGetResponseDTO();
        BeanUtils.copyProperties(conta, responseDTO);
        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta cadastrarConta(@RequestBody @Valid ContaPostRequestDTO contaDTO) {
        return contaService.criarConta(contaDTO);
    }

    @DeleteMapping("/{id}")
    public String removerConta(@PathVariable Integer id) {
        contaService.removerConta(id);
        return "Deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Conta atualizarConta(@PathVariable Integer id ,@RequestBody Conta conta) {
        return contaService.atualizarConta(id, conta);
    }

    @PatchMapping()
    public Conta alterarLimite(@RequestParam Integer id, @RequestParam Double limite) {
        return contaService.alterarLimite(id, limite);
    }
}