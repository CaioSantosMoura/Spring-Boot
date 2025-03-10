package net.weg.banco.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.banco.model.dto.ClienteContaGetResponseDTO;
import net.weg.banco.model.dto.ClienteResponseDTO;
import net.weg.banco.model.dto.ContaClienteResponseDTO;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_cliente")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Long cpf;
    @OneToMany(mappedBy = "titular",
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE},
            orphanRemoval = true)
    private List<Conta> contas;

    public void addConta(@NotNull Conta conta) {
        if (!contas.contains(conta)) {
            contas.add(conta);
        } else {
            throw new RuntimeException();
        }

    }

    public void removerConta(@NotNull Conta conta) {
        if (!contas.contains(conta)) {
            throw new RuntimeException();
        } else {
            contas.remove(conta);
            conta.setTitular(null);
        }
    }

    public List<Conta> getContas() {
        if (this.contas != null) {
            return this.contas;
        }
        return new ArrayList<>();
    }

    public ClienteContaGetResponseDTO convert() {
        return new ClienteContaGetResponseDTO(this.id, this.nome, this.cpf);
    }

    public ClienteResponseDTO convertoToClienteResponseDTO() {

        if (this.contas != null) {
            List<ContaClienteResponseDTO> contasDTO = this.contas.stream().map(Conta::convertToContaClienteResponseDTO).toList();
            return new ClienteResponseDTO(this.id, this.nome, this.cpf, contasDTO);
        }
        return new ClienteResponseDTO(this.id, this.nome, this.cpf, null);

    }
}