package com.example.integrador.repositorio;

import com.example.integrador.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email); // Método para buscar cliente por email
}
