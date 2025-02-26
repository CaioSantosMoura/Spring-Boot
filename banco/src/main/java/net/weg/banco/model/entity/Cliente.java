package net.weg.banco.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    private Set<Conta> contas;

    public Set<Conta> getContas() {
        return Collections.unmodifiableSet(contas);
    }

    public void addConta(@NotNull Conta conta) {
        this.contas.add(conta);
    }

    public void removerConta(@NotNull @Positive Conta conta) {
        for (Conta conta1 : contas) {
            if(conta1.getId().equals(conta.getId())) {
                this.contas.remove(conta1);
                return;
            }
        }
    }
//    @ManyToMany
//    @JoinTable(
//            name = "tb_cliente_conta",
//            joinColumns =
//            @JoinColumn(name = "cliente_id"),
//            inverseJoinColumns =
//            @JoinColumn(name = "conta_id"))
//    @OneToOne(mappedBy = "titular")
//    private Conta conta;
}
