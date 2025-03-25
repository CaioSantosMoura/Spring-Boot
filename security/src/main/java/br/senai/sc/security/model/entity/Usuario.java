package br.senai.sc.security.model.entity;

import br.senai.sc.security.sec.model.entity.UsuarioDetails;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false, name = "usuario_details")
    private UsuarioDetails usuarioDetails;
}
