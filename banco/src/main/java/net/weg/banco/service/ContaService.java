package net.weg.banco.service;

import lombok.AllArgsConstructor;
import net.weg.banco.model.dto.ContaPostRequestDTO;
import net.weg.banco.model.entity.Conta;
import net.weg.banco.repository.ContaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ContaService {
    private final ContaRepository repository;

    public Conta criarConta(ContaPostRequestDTO contaDTO) {
        Conta conta = contaDTO.convert();
        return repository.save(conta);
    }

    public List<Conta> buscarContas() {
        return repository.findAll();
    }

    public Page<Conta> buscarContas(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Conta buscarConta(Integer id) {
        return repository.findById(id).get();
    }

    public void removerConta(Integer id) {
        repository.deleteById(id);
    }

    public Conta atualizarConta(Integer id, Conta conta) {
        conta.setId(id);
        return repository.save(conta);
    }

    public Conta alterarLimite(Integer id, Double limite) {
        Conta conta = buscarConta(id);
        conta.setLimite(limite);
        return repository.save(conta);
    }

}