package com.amaral.SeuCardapioDigital.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // Adicionando esta anotação explícita
public class SecurityConfig {

    private final SessaoAutenticacaoFilter sessaoFilter;

    // Injeção via construtor (mais testável e explícito)
    public SecurityConfig(SessaoAutenticacaoFilter sessaoFilter) {
        this.sessaoFilter = sessaoFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Configurações de segurança
                .csrf(csrf -> csrf.disable()) // Desabilitado para APIs stateless (avaliar necessidade)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // APIs REST devem ser stateless
                )
                .authorizeHttpRequests(auth -> auth
                        // Endpoints públicos
                        .requestMatchers(
                                "/open/**",
                                "/v3/api-docs/**",    // Documentação OpenAPI
                                "/swagger-ui/**",     // UI Swagger
                                "/swagger-resources/**"
                        ).permitAll()

                        // Endpoints autenticados
                        .requestMatchers("/auth/**").authenticated()

                        // Qualquer outra requisição deve ser negada por padrão (mais seguro)
                        .anyRequest().denyAll()
                )
                // Filtro customizado para autenticação via UUID
                .addFilterBefore(sessaoFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}