package net.weg.banco.service;

import lombok.AllArgsConstructor;
import net.weg.banco.model.Conta;
import net.weg.banco.repository.ContaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContaService {

    ContaRepository contaRepository;

    public void criarConta(Conta conta) {
        contaRepository.save(conta);
    }
}
