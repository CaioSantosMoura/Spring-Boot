package net.weg.banco.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.banco.model.dto.ClientePostRequestDTO;
import net.weg.banco.model.dto.ClientePutRequestDTO;
import net.weg.banco.model.dto.ClienteResponseDTO;
import net.weg.banco.model.entity.Cliente;
import net.weg.banco.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO cadastrarCliente(@Valid @RequestBody ClientePostRequestDTO clienteDTO) {
        Cliente cliente = clienteService.cadastrar(clienteDTO);
        return cliente.convertToClienteResponseDTO();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO editar(@PathVariable Integer id,
                                     @Valid @RequestBody ClientePutRequestDTO clienteDTO) {
        Cliente cliente = clienteService.editar(id, clienteDTO);
        return cliente.convertToClienteResponseDTO();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO alterarContas(@PathVariable Integer id, @RequestParam Integer idConta) {
        Cliente cliente = clienteService.alterarConta(id, idConta);
        return cliente.convertToClienteResponseDTO();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO buscarCliente(@PathVariable Integer id) {
        Cliente cliente = clienteService.buscarCliente(id);
        return cliente.convertToClienteResponseDTO();
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClienteResponseDTO> buscarClientes(@PageableDefault(
            size = 20,
            sort = "nome",
            direction = Sort.Direction.ASC,
            page = 0
    ) Pageable pageable) {
        Page<Cliente> clientePage = clienteService.buscarClientes(pageable);
        List<ClienteResponseDTO> contentList =
                clientePage.getContent().stream().map(Cliente::convertToClienteResponseDTO).toList();
        return new PageImpl<>(contentList, pageable, contentList.size());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable Integer id) {
        clienteService.removerCliente(id);
    }
}