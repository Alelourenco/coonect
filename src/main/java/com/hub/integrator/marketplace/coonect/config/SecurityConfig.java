package com.hub.integrator.marketplace.coonect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Desabilita CSRF para simplificar (não recomendado para produção)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/users/**").permitAll() // Permite acesso público ao endpoint de usuários
                        .anyRequest().permitAll() // Permite todas as requisições para fins de desenvolvimento
                );
        return http.build();
    }
}
