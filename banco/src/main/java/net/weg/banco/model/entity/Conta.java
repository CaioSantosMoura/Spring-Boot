package net.weg.banco.model.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.banco.model.dto.ContaClienteResponseDTO;
import net.weg.banco.model.dto.ContaResponseDTO;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    private Double saldo;
    private Double limite;
    @ManyToOne
    private Cliente titular;
//    @ManyToMany(mappedBy = "contas")
//    private List<Cliente> titulares;
//    @OneToOne
//    private Cliente titular;

    public static ContaBuilder builder() {
        return new ContaBuilder();
    }

    public ContaResponseDTO convert() {
        return new ContaResponseDTO(
                this.id, this.numero, this.saldo,
                this.limite, this.titular.convert());
    }

    public ContaResponseDTO convertToContaResponseDTO() {
        return new ContaResponseDTO(
                this.id,
                this.numero,
                this.saldo,
                this.limite,
                this.titular.convert());
    }

    public static class ContaBuilder {
        private Integer id;
        private Integer numero;
        private Double saldo = 0.0;
        private Double limite;
        private Cliente titular;

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

        public ContaBuilder cliente(Cliente titular) {
            this.titular = titular;
            return this;
        }

//        public ContaBuilder cliente(List<Cliente> titulares) {
//            this.titulares = titulares;
//            return this;
//        }

        public Conta build() {
            return new Conta(id,numero, saldo, limite, titular);
        }

        public ContaClienteResponseDTO convertToContaClienteResponseDTO() {
            return new ContaClienteResponseDTO(
                    this.id,
                    this.saldo,
                    this.limite,
                    this.numero);

        }
    }


}