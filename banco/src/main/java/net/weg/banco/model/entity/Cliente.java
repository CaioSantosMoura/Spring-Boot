package net.weg.banco.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Long cpf;
    @OneToMany(mappedBy = "titular")
    private Set<Conta> contas = new HashSet<>();
    //    @ManyToMany
//    @JoinTable(
//            name = "tb_cliente_conta",
//            joinColumns =
//            @JoinColumn(name = "cliente_id"),
//            inverseJoinColumns =
//            @JoinColumn(name = "conta_id"))
//    @OneToOne(mappedBy = "titular")
//    private Conta conta;

    public Set<Conta> getContas() {
        if (contas != null) {
            return Collections.unmodifiableSet(contas);
        }
        return new HashSet<>();
    }

    public void addConta(@NotNull Conta conta) {
        this.contas.add(conta);
    }

    public void removerConta(@NotNull @Positive Conta conta) {
        for (Conta conta1 : contas) {
            if (conta1.getId().equals(conta.getId())) {
                this.contas.remove(conta1);
                return;
            }
        }
    }

    public ClienteContaGetResponseDTO convert() {
        return new ClienteContaGetResponseDTO(
                this.id, this.nome, this.cpf);
    }

    public ClienteResponseDTO convertToClienteResponseDTO() {
        Set<ContaClienteResponseDTO> contasDTO =
                this.contas.stream().map(Conta::convertToContaClienteResponseDTO);
        return new ClienteResponseDTO(
                this.id,
                this.nome,
                this.cpf,
                contasDTO);
    }
}
