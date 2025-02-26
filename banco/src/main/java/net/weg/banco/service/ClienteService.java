package net.weg.banco.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import net.weg.banco.model.exceptions.MesmoTitularException;
import net.weg.banco.model.dto.ClientePostRequestDTO;
import net.weg.banco.model.dto.ClientePutRequestDTO;
import net.weg.banco.model.entity.Cliente;
import net.weg.banco.model.entity.Conta;
import net.weg.banco.repository.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ContaService service;

    public Cliente cadastrar(@Valid ClientePostRequestDTO clienteDTO) {
        Cliente cliente = clienteDTO.convert();
        return repository.save(cliente);
    }

    public Cliente editar(@NotNull @Positive Integer id, @Valid ClientePutRequestDTO clienteDTO) {
        if (repository.existsById(id)) {
            Cliente cliente = clienteDTO.convert();
            cliente.setId(id);
            return repository.save(cliente);
        }
        throw new NoSuchElementException();
    }

    public Cliente alterarConta(@NotNull @Positive Integer id, @NotNull @Positive Integer idConta) {
        Cliente cliente = repository.findById(id).get();
        Conta conta = service.buscarConta(idConta);
        if (cliente.getContas().contains(conta)) {
            cliente.removerConta(conta);
        } else if (conta.getTitular() == null) {
            cliente.addConta(conta);
        } else {
            throw new MesmoTitularException();
        }
        return repository.save(cliente);
    }

    public Cliente buscarCliente(Integer id) {
        return repository.findById(id).get();
    }

    public Page<Cliente> buscarClientes(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void removerCliente(Integer id) {
        repository.deleteById(id);
    }
}
