package br.senai.sc.security.repository;

import br.senai.sc.security.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    Usuario findByUsuarioDetails_Username(String usuario);
}
