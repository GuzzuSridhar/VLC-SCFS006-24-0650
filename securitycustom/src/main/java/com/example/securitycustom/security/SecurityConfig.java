package com.example.securitycustom.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // similar to @component
@EnableWebSecurity
public class SecurityConfig {

    // Creating a bean / instance of password encrytption service

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // create a bean with a list of users and their roles
    @Bean
    UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails uOne = User
                .withUsername("Alex")
                .password(encoder.encode("pass"))
                .roles("USER")
                .build();
        UserDetails uTwo = User
                .withUsername("Admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(uOne, uTwo);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                // restricting the access to the /sample only to admin role
                .requestMatchers("/sample").hasRole("ADMIN")
                // .requestMatchers("/sample").hasAnyRole("ADMIN","USER")

                // permitting the access to the login and log out pages to all (no
                // authentication required)
                .requestMatchers("/", "/login", "/logout", "/403").permitAll()

                // .requestMatchers("/test").denyAll()

                // assign access to all authenticated users to the end points "/home",
                // "/sample"
                // .requestMatchers("/home").authenticated()
                .anyRequest().authenticated())

                .formLogin(fl -> fl
                        .successForwardUrl("/home")
                        .loginPage("/login"))
                .logout(lo -> lo.logoutSuccessUrl("/login"))

                .csrf(c -> c.disable())

                // customizing the html error pages
                .exceptionHandling(ex -> ex.accessDeniedPage("/403"));

        return http.build();

    }

}
