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

    private final ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO cadastro(@RequestBody @Valid ClientePostRequestDTO clienteDTO){
        Cliente cliente = service.cadastrar(clienteDTO);
        return cliente.convertoToClienteResponseDTO();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO editar(@RequestBody @Valid ClientePutRequestDTO clienteDTO,
                                     @PathVariable Integer id){
        Cliente cliente = service.editar(clienteDTO, id);
        return cliente.convertoToClienteResponseDTO();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO alterarContas( @PathVariable Integer id, @RequestParam Integer idConta){
        Cliente cliente = service.alterarConta(id, idConta);
        return cliente.convertoToClienteResponseDTO();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO buscarCliente(@PathVariable Integer id){
        Cliente cliente = service.buscar(id);
        return cliente.convertoToClienteResponseDTO();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClienteResponseDTO> buscarClientes(@PageableDefault(
            size = 20,
            sort = "nome",
            direction = Sort.Direction.DESC,
            page = 0
    ) Pageable pageable){

        Page<Cliente> clientePage = service.buscar(pageable);
        List<ClienteResponseDTO> contentList = clientePage.getContent().stream().map(
                Cliente::convertoToClienteResponseDTO).toList();

        return new PageImpl<>(contentList, clientePage.getPageable(), clientePage.getTotalElements());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable Integer id){
        service.remover(id);
    }
}