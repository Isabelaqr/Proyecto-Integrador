package com.example.avanceintegrador.repositorio;

import com.example.avanceintegrador.entidad.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioClienteRepositorio extends JpaRepository<UsuarioCliente, Long> {
    UsuarioCliente findByEmail(String email);
}
