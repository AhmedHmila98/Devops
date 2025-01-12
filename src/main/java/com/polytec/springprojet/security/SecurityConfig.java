package com.polytec.springprojet.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(form ->form.permitAll());
        httpSecurity.exceptionHandling(exception-> exception.accessDeniedPage("/erreur"));
        httpSecurity.authorizeHttpRequests(request -> request.requestMatchers("emplyees/admin/**").hasRole("ADMIN")
                .requestMatchers("tachees/admin/**").hasRole("ADMIN")
                .requestMatchers("projet/admin/**").hasRole("ADMIN").anyRequest().authenticated()
                );


        return httpSecurity.build();
    }

    @Bean
    InMemoryUserDetailsManager userDetailsManager()
    {
        return new InMemoryUserDetailsManager(User.withUsername("user").password(passwordEncoder().encode("123")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder().encode("123")).roles("User","ADMIN").build());    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
