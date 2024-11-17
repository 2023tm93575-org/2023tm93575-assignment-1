package org.book.extra;

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
                .csrf().disable().authorizeRequests()
                .requestMatchers("/books").authenticated()  // Protect /books endpoint
                .anyRequest().permitAll()
                .and()
                .httpBasic();  // Enable Basic Authentication
        return http.build();
    }
}
