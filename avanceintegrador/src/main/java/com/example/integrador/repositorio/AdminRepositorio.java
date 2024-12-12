package com.example.integrador.repositorio;

import com.example.integrador.entidad.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepositorio extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);

}
