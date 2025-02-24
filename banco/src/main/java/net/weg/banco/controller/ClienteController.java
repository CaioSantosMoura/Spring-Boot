package net.weg.banco.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.banco.model.dto.ClientePostRequestDTO;
import net.weg.banco.model.entity.Cliente;
import net.weg.banco.repository.ClienteRepository;
import net.weg.banco.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    private final ClienteRepository clienteRepository;
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

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Cliente clientePorId(@PathVariable Integer id) {
        return clienteRepository.findById(id).get();
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
}