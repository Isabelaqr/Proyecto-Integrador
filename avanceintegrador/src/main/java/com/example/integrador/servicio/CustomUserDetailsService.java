package com.example.integrador.servicio;

import com.example.integrador.entidad.Admin;
import com.example.integrador.repositorio.AdminRepositorio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepositorio adminRepositorio;

    public CustomUserDetailsService(AdminRepositorio adminRepositorio) {
        this.adminRepositorio = adminRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepositorio.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Si tienes solo un rol, pasamos un solo rol como un array
        return org.springframework.security.core.userdetails.User.builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                // Como solo tienes un rol, pasamos un arreglo con un solo elemento
                .roles(admin.getRole())
                .build();
    }
}