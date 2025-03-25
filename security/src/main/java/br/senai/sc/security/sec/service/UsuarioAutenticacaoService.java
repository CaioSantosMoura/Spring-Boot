package br.senai.sc.security.sec.service;

import br.senai.sc.security.sec.repository.UsuarioDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioAutenticacaoService
        implements UserDetailsService {

    private final  UsuarioDetailsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() ->
        new UsernameNotFoundException(username + " não encontrado"));
    }
}
