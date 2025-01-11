package com.example.oauth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    public SecurityFilterChain securityFilterChain(HttpSecurity hSecurity) throws Exception {
        hSecurity
                .authorizeHttpRequests((req) -> req
                        .anyRequest().authenticated())
                .oauth2Login((login) -> login
                        .redirectionEndpoint((endpoint) -> endpoint
                                .baseUri("/login/oauth2/callback/*")))
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll()
                        .invalidateHttpSession(true));

        return hSecurity.build();
    }
}
