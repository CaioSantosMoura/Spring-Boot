package net.weg.banco.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.banco.model.dto.ContaResponseDTO;
import net.weg.banco.model.dto.ContaPostRequestDTO;
import net.weg.banco.model.entity.Conta;
import net.weg.banco.service.ContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/conta")
public class ContaController {

    ContaService contaService;

    @GetMapping
    public List<ContaResponseDTO> buscarTodasAsContas() {
        List<Conta> contas = contaService.buscarContas();
        return contas.stream().map(Conta::convertToContaResponseDTO).toList();
    }

    @GetMapping("/page")
    public Page<ContaResponseDTO> buscarTodasAsContas(
            @PageableDefault(size = 20,
                    sort = "saldo",
                    direction = Sort.Direction.DESC,
                    page = 0
            ) Pageable pageable) {
        Page<Conta> contasPage = contaService.buscarContas(pageable);
        List<ContaResponseDTO> contasResponseList =
                contasPage.getContent().stream().map
                        (Conta::convertToContaResponseDTO).toList();
        return new PageImpl<>(contasResponseList,
                pageable, contasPage.getTotalElements());
    }

    @GetMapping("/{id}")
    public ContaResponseDTO buscarContaPorId(@PathVariable Integer id) {
        Conta conta = contaService.buscarConta(id);
        return conta.convertToContaResponseDTO();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaResponseDTO cadastrarConta(@RequestBody @Valid ContaPostRequestDTO contaDTO) {
        Conta conta = contaService.criarConta(contaDTO);
        return conta.convertToContaResponseDTO();
    }

    @DeleteMapping("/{id}")
    public String removerConta(@PathVariable Integer id) {
        contaService.removerConta(id);
        return "Deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public ContaResponseDTO atualizarConta(@PathVariable Integer id, @RequestBody ContaPutRequestDTO contaDTO) {
        Conta conta = contaDTO.convert();
        return conta.convertToContaResponseDTO();
    }

    @PatchMapping()
    public ContaResponseDTO alterarLimite(@RequestParam Integer id, @RequestParam Double limite) {
        Conta contaDTO = contaService.alterarLimite(id, limite);
        return contaDTO.convertToContaResponseDTO();
    }
}