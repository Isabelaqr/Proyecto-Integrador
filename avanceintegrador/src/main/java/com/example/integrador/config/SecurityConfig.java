package com.example.integrador.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Deshabilitamos CSRF (no recomendado en producción sin medidas adicionales)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index", "/register", "/loginadmin", "/carrito",
                                "/preguntas", "/anuncios", "/cliente", "/iniciocliente","/boleta",
                                "/login", "/nosotros", "/privacidad", "/producto", "/graficos",
                                "/proveedor", "/registrocliente", "/tienda", "/terminosycondiciones")
                        .permitAll() // Permitir estas rutas sin autenticación
                        .anyRequest().authenticated() // Proteger las demás rutas
                )
                .formLogin(form -> form
                        .loginPage("/loginadmin") // Página de login personalizada
                        .defaultSuccessUrl("/admin", true) // Redirigir al admin después de iniciar sesión
                        .failureUrl("/loginadmin?error=true") // Redirigir con error=true en caso de fallo de login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL para logout
                        .logoutSuccessUrl("/?logout") // Redirigir al index después de salir
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}