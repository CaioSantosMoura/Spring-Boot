package net.weg.banco.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
//    @OneToMany(mappedBy = "titular")
//    private List<Conta> contas;
//    @ManyToMany
//    @JoinTable(
//            name = "tb_cliente_conta",
//            joinColumns =
//            @JoinColumn(name = "cliente_id"),
//            inverseJoinColumns =
//            @JoinColumn(name = "conta_id"))
    @OneToOne(mappedBy = "titular")
    private Conta conta;
}
