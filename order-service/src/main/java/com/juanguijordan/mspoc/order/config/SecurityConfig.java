package com.juanguijordan.mspoc.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/actuator/**").permitAll() // Exclude actuator endpoints if needed
                .anyRequest().authenticated() // Protect all other endpoints
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt()); // Enable JWT-based authentication
        return http.build();
    }

    // @Bean
    // public JwtAuthenticationConverter jwtAuthenticationConverter() {
    //     JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
    //     // Optionally customize roles claim mapping if needed
    //     return converter;
    // }
}
