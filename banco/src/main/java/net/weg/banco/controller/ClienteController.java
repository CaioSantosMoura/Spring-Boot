package net.weg.banco.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.banco.model.dto.ClientePostRequestDTO;
import net.weg.banco.model.dto.ClientePutRequestDTO;
import net.weg.banco.model.dto.ClienteResponseDTO;
import net.weg.banco.model.entity.Cliente;
import net.weg.banco.repository.ClienteRepository;
import net.weg.banco.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrarCliente(@Valid @RequestBody ClientePostRequestDTO clienteDTO) {
        return clienteService.cadastrar(clienteDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente editar(@PathVariable Integer id,
                          @Valid @RequestBody ClientePutRequestDTO clienteDTO) {
        return clienteService.editar(id, clienteDTO);
    }
//
//    @PatchMapping
//    @ResponseStatus(HttpStatus.OK)
//    public Cliente alterarContas(@PathVariable Integer id,  @RequestParam Integer idConta) {
//        return clienteService.alterarConta(id, idConta);
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO buscarCliente(@PathVariable Integer id) {
        Cliente cliente = clienteService.buscarCliente(id);
        return cliente.convert();
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Cliente> buscarClientes(@PageableDefault(
            size = 20,
            sort = "nome",
            direction = Sort.Direction.ASC,
            page = 0
    ) Pageable pageable) {
        return clienteService.buscarClientes(pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable Integer id) {
        clienteService.removerCliente(id);
    }
}