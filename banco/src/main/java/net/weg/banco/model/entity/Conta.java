package net.weg.banco.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private Integer numero;
    @NonNull
    private Double saldo;
    @NonNull
    private Double limite;
    @NonNull
    private String titular;

    public static ContaBuilder builder() {
        return new ContaBuilder();
    }

    public static class ContaBuilder {
        private Integer id;
        private Integer numero;
        private Double saldo;
        private Double limite;
        private String titular;

        public ContaBuilder id(Integer id){
            this.id = id;
            return this;
        }
        public ContaBuilder numero(Integer numero) {
            this.numero = numero;
            return this;
        }
        public ContaBuilder saldo(Double saldo) {
            this.saldo = saldo;
            return this;
        }
        public ContaBuilder limite(Double limite) {
            this.limite = limite;
            return this;
        }
        public ContaBuilder titular(String titular) {
            this.titular = titular;
        }

        public Conta build() {
            return new Conta(id,numero, saldo, limite, titular);
        }
    }


}