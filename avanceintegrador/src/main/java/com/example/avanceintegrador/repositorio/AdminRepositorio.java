package com.example.avanceintegrador.repositorio;

import com.example.avanceintegrador.entidad.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositorio extends JpaRepository<Admin, Long> {
    Admin findByUsuario(String usuario);
}
