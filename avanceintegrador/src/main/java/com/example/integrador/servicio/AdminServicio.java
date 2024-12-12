package com.example.integrador.servicio;

import com.example.integrador.entidad.Admin;
import com.example.integrador.repositorio.AdminRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServicio {

    private final AdminRepositorio adminRepositorio;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminServicio(AdminRepositorio adminRepositorio, PasswordEncoder passwordEncoder) {
        this.adminRepositorio = adminRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    public void registrarUsuario(String name, String username, String email, String password, String role) {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setUsername(username);
        admin.setEmail(email);
        admin.setPassword(passwordEncoder.encode(password));
        admin.setRole(role);
        adminRepositorio.save(admin);
    }

    public Optional<Admin> buscarPorUsername(String username) {
        return adminRepositorio.findByUsername(username);
    }

}
