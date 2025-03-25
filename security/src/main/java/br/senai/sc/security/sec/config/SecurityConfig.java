package br.senai.sc.security.sec.config;

import br.senai.sc.security.sec.service.UsuarioAutenticacaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
//    @Bean
//    public UserDetailsService users(){
//        InMemoryUserDetailsManager manager =
//                new InMemoryUserDetailsManager();
//        manager.createUser(User.builder()
//                .username("admin")
//                .password("Senh@Fort3")
//                .build());
//        manager.createUser(User.builder()
//                .username("user")
//                .password("Fort3Senh@")
//                .build());
//        return manager;
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(UsuarioAutenticacaoService uds) {
        DaoAuthenticationProvider ap =
                new DaoAuthenticationProvider();

        ap.setUserDetailsService(uds);
        ap.setPasswordEncoder(passwordEncoder());

        return ap;
    }

//    @Bean
    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}
