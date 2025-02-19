package net.weg.banco.service;

import lombok.AllArgsConstructor;
import net.weg.banco.model.dto.ContaPostRequestDTO;
import net.weg.banco.model.entity.Conta;
import net.weg.banco.repository.ContaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContaService {

    ContaRepository contaRepository;

    public Conta criarConta(ContaPostRequestDTO contaDTO) {
        Conta conta = contaDTO.convert();
        return contaRepository.save(conta);
    }

    public List<Conta> buscarContas() {
        return contaRepository.findAll();
    }

    public Page<Conta> buscarContas(Pageable pageable) {
        return contaRepository.findAll(pageable);
    }

    public Conta buscarConta(Integer id) {
        return contaRepository.findById(id).get();
    }

    public void removerConta(Integer id) {
        contaRepository.deleteById(id);
    }

    public Conta atualizarConta(Integer id, Conta conta) {
        conta.setId(id);
        return contaRepository.save(conta);
    }

    public Conta alterarLimite(Integer id, Double limite) {
        Conta conta = buscarConta(id);
        conta.setLimite(limite);
        return contaRepository.save(conta);
    }
}